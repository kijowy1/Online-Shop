package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.model.UpdateProductCommand;
import com.springdemo.nobsv2.product.validators.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {
    //tu odpowiednio dziala aktualizowanie produktu, jak ma dzialac funckja updagte
    //to jest to wstrzykiwanie zaleznosci
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(UpdateProductService.class);

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()) {
                Product oldProduct = productOptional.get(); Product newProduct = command.getProduct();
                logger.info("Updating " + oldProduct.getName() + " id " + oldProduct.getId() );
                ProductValidator.execute(newProduct);
                StringBuilder productChanges = changeLog(newProduct,oldProduct);
                newProduct.setId(command.getId());
                productRepository.save(newProduct);
                logger.info("Succesfully updated " + productChanges);
                return ResponseEntity.ok(new ProductDTO(newProduct));
        }
        //jezeli not found trzeba ladnie poinformowac uzytkownika ze cos zle wpsisal albo nie ma
        throw new ProductNotFoundException();

    }
    public static <T> void appendIfChanged(
            Product newProduct,
            Product oldProduct,
            StringBuilder sb,
            String fieldName,
            Function<Product, T> getter) {
        T oldValue = getter.apply(oldProduct);
        T newValue = getter.apply(newProduct);
        if(!Objects.equals(oldValue,newValue)){
                  sb.append(fieldName)
                    .append(" ")
                    .append(oldValue)
                    .append(" -> ")
                    .append(newValue)
                    .append("\n");
        }
    }
    public StringBuilder changeLog(Product newProduct, Product oldProduct){
        StringBuilder sb = new StringBuilder();
        appendIfChanged(newProduct,oldProduct,sb,"Name: ",Product::getName);
        appendIfChanged(newProduct,oldProduct,sb,"Price: ",Product::getPrice);
        appendIfChanged(newProduct,oldProduct,sb,"Description: ",Product::getDescription);
        appendIfChanged(newProduct,oldProduct,sb,"Quantity: ",Product::getQuantity);

        return sb;
    }
}
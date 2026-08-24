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

import java.util.Optional;

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
                Product oldProduct = productOptional.get();
                Product newProduct = command.getProduct();
                logger.info("Updating " + oldProduct.getName() + " id " + oldProduct.getId() );
                ProductValidator.execute(oldProduct);
                StringBuilder productChanges = new StringBuilder();
                if(!newProduct.getName().equals(oldProduct.getName())){
                    productChanges.append("Name: " + oldProduct.getName() +
                            " -> " + newProduct.getName() + "\n");
                }
                if(!newProduct.getDescription().equals(oldProduct.getDescription())){
                    productChanges.append("Description: " + oldProduct.getDescription() +
                            " -> " + newProduct.getDescription() + "\n");
                }
                if(!newProduct.getPrice().equals(oldProduct.getPrice())){
                    productChanges.append("Price: " + oldProduct.getPrice() +
                            " -> " + newProduct.getPrice() + "\n");
                }
                if(!newProduct.getQuantity().equals(oldProduct.getQuantity())){
                    productChanges.append("Price: " + oldProduct.getQuantity() +
                            " -> " + newProduct.getQuantity() + "\n");
                }
                newProduct.setId(command.getId());
                productRepository.save(newProduct);
                logger.info("Succesfully updated - " + productChanges);
                return ResponseEntity.ok(new ProductDTO(newProduct));
        }
        //jezeli not found trzeba ladnie poinformowac uzytkownika ze cos zle wpsisal albo nie ma
        throw new ProductNotFoundException();

    }
    // TODO:
    //  Logger function
}
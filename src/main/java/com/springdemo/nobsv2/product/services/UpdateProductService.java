package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.model.UpdateProductCommand;
import com.springdemo.nobsv2.product.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {
    //tu odpowiednio dziala aktualizowanie produktu, jak ma dzialac funckja updagte
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()) {
                Product product = command.getProduct();
             //   ProductValidator.execute(product);
                product.setId(command.getId());
                productRepository.save(product);
                return ResponseEntity.ok(new ProductDTO(product));
        }
        //jezeli not found trzeba ladnie poinformowac uzytkownika ze cos zle wpsisal albo nie ma
        throw new ProductNotFoundException();

    }
}
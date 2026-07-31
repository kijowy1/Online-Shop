package com.springdemo.nobsv2.product.services;

import ch.qos.logback.core.util.StringUtil;
import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ErrorMessages;
import com.springdemo.nobsv2.exceptions.ProductNotValidException;
import com.springdemo.nobsv2.product.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product,ProductDTO> {
    //tu odpowiednio dziala tworzenie kazdego produktu, jak ma dzialac funckja CREATE
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        ProductValidator.execute(product);
        Product savedProduct = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));

    }
}
package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.validators.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//Tu odpowiednio dziala tworzenie kazdego produktu, jak ma dzialac funckja CREATE

@Service
public class CreateProductService implements Command<Product,ProductDTO> {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(CreateProductService.class);

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        ProductValidator.execute(product);
        Product savedProduct = productRepository.save(product);
        logger.info("Succesfully created product: " + product.getName() + " with id: " + product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));

    }
}
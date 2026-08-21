package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Command;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer,Void> {
    //tu odpowiednio dziala usuwanie produktu, jak ma dzialac funckja DELETE
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(DeleteProductService.class);
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        logger.info("!!! Deleting product with id " + id + " !!!");
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            productRepository.deleteById(id);
            logger.info("Succesfully deleted product with id " + id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        //later
        throw new ProductNotFoundException();
    }
}

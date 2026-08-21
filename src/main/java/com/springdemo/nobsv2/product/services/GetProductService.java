package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

//Tutaj odpowiednio dziala wypisywanie pojedycznego produktu, opisana funckja GET.

@Service
public class GetProductService implements Query<Integer, ProductDTO> {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(GetProductService.class);

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        //optional, if u can find it
        logger.info("Executing " + getClass() + " input");
        Optional<Product> productOptional = productRepository.findById(input);
        if(productOptional.isPresent()){
            // jezeli takie id jest, zwracamy produkt
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();


    }
}
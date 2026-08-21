package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

//Search product function searches through given ID, Name, Price and find you result
@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //TODO: SearchProducts should return limited amount of products - 20
    // SearchProducts should give you option to filter thorugh more than one way,
    // like name and price : "coffee" "20-40"
    // FindBy "type"
    private static final Logger logger = LoggerFactory.getLogger(SearchProductService.class);
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String input) {
        logger.info("Searching for " + input);
        return ResponseEntity.ok(productRepository.findByNameContaining(input)
                .stream()
                .map(ProductDTO::new)
                .toList());

    }
}
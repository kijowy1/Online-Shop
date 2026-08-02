package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

//Search product function searches through given ID, Name, Price and find you result

//TODO:
// SearchProducts should return limited amount of products - 20
// SearchProducts should give you option to filter thorugh more than one way,
// like name and price : "coffee" "20-40"
@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;
    @Override
    public ResponseEntity<List<ProductDTO>> execute(String input) {
        return ResponseEntity.ok(productRepository.findByNameContaining(input)
                .stream()
                .map(ProductDTO::new)
                .toList());

    }


}
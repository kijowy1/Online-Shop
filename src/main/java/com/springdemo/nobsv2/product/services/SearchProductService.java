package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.product.ProductRepository;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;
    @Override
    public ResponseEntity<List<ProductDTO>> execute(String input) {
        return null;
    }
}
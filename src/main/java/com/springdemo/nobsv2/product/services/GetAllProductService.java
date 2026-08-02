package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
// Tu odpowiednio dziala wylistowanie kazdego produktu, opisana jest funckja getALLProduct

@Service
public class GetAllProductService implements Query<Void,List<ProductDTO>> {
    private final ProductRepository productRepository;

    public GetAllProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

        //nie ma sensu dawac exception gdy nie ma produktow, wyrzucamy pusta liste
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);


    }
}
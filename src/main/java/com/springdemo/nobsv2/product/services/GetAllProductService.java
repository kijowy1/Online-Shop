package com.springdemo.nobsv2.product.services;

import com.springdemo.nobsv2.Query;
import com.springdemo.nobsv2.product.validators.ProductRepository;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import org.springframework.data.domain.Page;
// Tu odpowiednio dziala wylistowanie kazdego produktu, opisana jest funckja getALLProduct

@Service
public class GetAllProductService implements Query<Pageable,Page<ProductDTO>> {
    private final ProductRepository productRepository;

    public GetAllProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(GetAllProductService.class);

    @Override
    public ResponseEntity<Page<ProductDTO>> execute(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);

        Page<ProductDTO> productDTOPage = productPage.map(ProductDTO::new);
        logger.info("Listing all products with size " + pageable.getPageSize()
                + " at page number " + pageable.getPageNumber());
        //nie ma sensu dawac exception gdy nie ma produktow, wyrzucamy pusta liste
        return ResponseEntity.status(HttpStatus.OK).body(productDTOPage);

    }
}
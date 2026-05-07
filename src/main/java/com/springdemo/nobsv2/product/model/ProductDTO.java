package com.springdemo.nobsv2.product.model;

import com.springdemo.nobsv2.product.ProductRepository;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name  = product.getName();
        this.price = product.getPrice();
    }
}
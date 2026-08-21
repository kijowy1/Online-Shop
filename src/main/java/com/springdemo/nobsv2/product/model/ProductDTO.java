package com.springdemo.nobsv2.product.model;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    //tutaj funckja ktora daje informacje o produkcie
    public ProductDTO(Product product){
        this.id = product.getId();
        this.name  = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }
}
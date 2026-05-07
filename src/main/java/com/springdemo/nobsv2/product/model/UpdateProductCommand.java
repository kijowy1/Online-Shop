package com.springdemo.nobsv2.product.model;

import lombok.Getter;

@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;

    public UpdateProductCommand(Product product, Integer id) {
        this.product = product;
        this.id = id;
    }
}
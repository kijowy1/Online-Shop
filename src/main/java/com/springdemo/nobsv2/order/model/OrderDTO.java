package com.springdemo.nobsv2.order.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Integer id;
    private String productName;
    private Integer customerId;
    private Double price;
    private String status;
    private LocalDateTime createdAt;
    public OrderDTO(Order order){
        this.id = order.getId();
        this.productName = order.getProductName();
        this.customerId = order.getCustomerId();
        this.price = order.getPrice();
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
    }
}
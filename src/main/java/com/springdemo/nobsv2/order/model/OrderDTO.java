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
    private OrderDTO(Order order){
        this.id = order.getId();
        this.productName = getProductName();
        this.customerId = getCustomerId();
        this.price = getPrice();
        this.status = getStatus();
        this.createdAt = getCreatedAt();
    }
}
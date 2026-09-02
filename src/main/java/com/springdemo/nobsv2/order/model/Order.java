package com.springdemo.nobsv2.order.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id //  tablice w sql potrzebuja glownego klucza
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generuje id
    @Column(name = "id")
    private Integer Id;
    // tutaj mamy wymagania co musi spelnic ADD aby dodac produkt produktow

    @NotNull(message = "Name is Required")
    @Column(name = "name_of_product")
    private String productName;

    @Column(name = "customer_Id")
    private Integer customerId;


    @PositiveOrZero(message = "price must be positive or zero")
    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
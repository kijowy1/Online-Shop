package com.springdemo.nobsv2.product.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Table(name="product")
public class Product {

    @Id //  tablice w sql potrzebuja glownego klucza
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generuje id
    @Column(name = "id")
    private Integer Id;

    @Column(name = "name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name = "price")
    private double price;

}
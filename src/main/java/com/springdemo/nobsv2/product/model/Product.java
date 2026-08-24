package com.springdemo.nobsv2.product.model;

import com.springdemo.nobsv2.exceptions.ErrorMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Data
@Table(name="product")
public class Product {

    @Id //  tablice w sql potrzebuja glownego klucza
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generuje id
    @Column(name = "id")
    private Integer Id;
    // tutaj mamy wymagania co musi spelnic ADD aby dodac produkt produktow

    @NotNull(message = "Name is Required")
    @Column(name = "name")
    private String name;

    @Size(min = 20, message = "Description must be at least 20 characters ")
    @Column(name ="description")
    private String description;

    @PositiveOrZero(message = "price must be positive or zero")
    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

}
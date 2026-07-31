package com.springdemo.nobsv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//wyrzuca informacje gdy nie znaleziono produktu
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
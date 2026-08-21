package com.springdemo.nobsv2.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//wyrzuca informacje gdy nie znaleziono produktu
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
        logger.error("Exception " + getMessage() + " thrown");
    }
}
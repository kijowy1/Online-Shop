package com.springdemo.nobsv2.product.validators;

import ch.qos.logback.core.util.StringUtil;
import com.springdemo.nobsv2.exceptions.ErrorMessages;
import com.springdemo.nobsv2.exceptions.ProductNotValidException;
import com.springdemo.nobsv2.product.model.Product;

public class ProductValidator {
    private ProductValidator(){

    }
    public static void execute(Product product) {
        if(StringUtil.isNullOrEmpty(product.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if(product.getDescription().length() < 20 ){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_TOO_SHORT.getMessage());
        }

        if(product.getPrice() == null || product.getPrice() < 0){
            throw new ProductNotValidException(ErrorMessages.NEGATIVE_PRICE.getMessage());
        }
    }
}
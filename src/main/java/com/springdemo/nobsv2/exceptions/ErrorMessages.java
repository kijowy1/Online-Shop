package com.springdemo.nobsv2.exceptions;

public enum ErrorMessages {
    SOMETHING_WENT_WRONG("Oops,something went wrong"),
    PRODUCT_NOT_FOUND("Product Not Found"),
    NAME_REQUIRED("name is required"),
    DESCRIPTION_TOO_SHORT("description must be at least 20 characters"),
    NEGATIVE_PRICE("price cannot be negative");
    //mozna dodawc tu rozne wiadomosci na errory
    //wszystkie wiadomosci sa w jednym miejscu


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

package com.springdemo.nobsv2.product.model;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String message;3
    //Tu mozna dodac co sie chce zeby wyrzucalo gdy jest error
    public ErrorResponse(String message) {
        this.message = message;
    }
}

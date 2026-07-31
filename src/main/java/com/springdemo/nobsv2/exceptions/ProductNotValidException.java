package com.springdemo.nobsv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//wyrzuca message gdy cos jest nie tak
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotValidException extends RuntimeException {
    public ProductNotValidException(String message){
        super(message);// super przekazuje (message) wyzej, do runtimeException, a tam to juz zalatwia
                        // tak ze wyrzuca wlasnie message
                        //tak jest szybciej i latwiej,
                        // masz swoja klase product notValid, przekazac message wyzej
                        //potem dopisac cos swojego co sie dzieje potem
    }
}
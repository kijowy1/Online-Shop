package com.springdemo.nobsv2.exceptions;

import com.springdemo.nobsv2.product.model.ErrorResponse;
import com.springdemo.nobsv2.product.services.GetAllProductService;
import com.springdemo.nobsv2.product.services.GetProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
//obsluga bledow, idk musze opisac to pozniej mam stan depresyjny teraz
@ControllerAdvice
public class GlobalExceptionHandler {
    private final GetAllProductService getAllProductService;
    private final GetProductService getProductService;

    public GlobalExceptionHandler(GetAllProductService getAllProductService, GetProductService getProductService) {
        this.getAllProductService = getAllProductService;
        this.getProductService = getProductService;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage()));
    }
    @ExceptionHandler(ProductNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleProductNotValidException(ProductNotValidException exception ){
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorResponseResponseEntity(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Oops something went wrong... " + exception.getMessage());
    }
}


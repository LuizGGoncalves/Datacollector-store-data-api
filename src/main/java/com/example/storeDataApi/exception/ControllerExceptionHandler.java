package com.example.storeDataApi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CurrencyNotFoundException.class)
    public Map<String, String> handleCurrencyNotFound(CurrencyNotFoundException ex){
        Map<String,String> erroMap = new HashMap<>();
        erroMap.put("Errors", ex.getMessage());
        return erroMap;
    }
}

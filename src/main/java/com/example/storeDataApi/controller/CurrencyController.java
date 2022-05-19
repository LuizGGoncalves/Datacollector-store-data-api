package com.example.storeDataApi.controller;

import com.example.storeDataApi.model.Currency;
import com.example.storeDataApi.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @ApiIgnore
    @PostMapping("/")
    public ResponseEntity<Currency> reciveCurrency(@RequestBody Currency currency) {
        return new ResponseEntity<Currency>(currencyService.save(currency), HttpStatus.CREATED);
    }

    @GetMapping("/currency/{name}")
    public ResponseEntity<Currency> getCurrency(@PathVariable(value = "name") String name){
        return new ResponseEntity<Currency>(currencyService.getCurrency(name),HttpStatus.ACCEPTED);
    }
}

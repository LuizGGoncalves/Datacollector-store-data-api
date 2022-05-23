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
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.save(currency));
    }

    @GetMapping("/currency/{name}")
    public ResponseEntity<Currency> getCurrency(@PathVariable(value = "name") String name){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyService.getCurrency(name));
    }
}

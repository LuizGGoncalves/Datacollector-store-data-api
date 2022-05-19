package com.example.storeDataApi.service;

import com.example.storeDataApi.exception.CurrencyNotFoundException;
import com.example.storeDataApi.model.Currency;

public interface CurrencyService {
    Currency save(Currency currency) throws CurrencyNotFoundException;
    Currency getCurrency(String name) throws CurrencyNotFoundException;
}

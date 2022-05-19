package com.example.storeDataApi.service.serviceImplements;

import com.example.storeDataApi.exception.CurrencyNotFoundException;
import com.example.storeDataApi.model.Currency;
import com.example.storeDataApi.repository.CurrencyRepository;
import com.example.storeDataApi.service.CurrencyService;
import org.springframework.stereotype.Service;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency save(Currency currency) {
        Currency oldCurrency = currencyRepository.findBycurrencyName(currency.getCurrencyName())
                .orElseThrow(()-> new CurrencyNotFoundException("Essa moeda nao foi encontrada"));
        oldCurrency.upDateFrom(currency);
        return currencyRepository.save(oldCurrency);
    }

    @Override
    public Currency getCurrency(String name) {
       return currencyRepository.findBycurrencyName(name)
               .orElseThrow(()-> new CurrencyNotFoundException("Essa moeda nao foi encontrada"));
    }

}

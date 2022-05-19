package com.example.storeDataApi.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void upDateFrom() {
        Currency currency1 = new Currency(1L,"BitCoin",30d,35d,40d,45d);
        Currency currency2 = new Currency(1L,"BitCoin",30d,35d,50d,50d);

        currency1.upDateFrom(currency2);
        assertEquals(currency1, currency2);
    }
}
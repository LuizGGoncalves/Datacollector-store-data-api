package com.example.storeDataApi.service.serviceImplements;

import com.example.storeDataApi.StoreDataApiApplication;
import com.example.storeDataApi.exception.CurrencyNotFoundException;
import com.example.storeDataApi.model.Currency;
import com.example.storeDataApi.repository.CurrencyRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;


@SpringBootTest(classes = StoreDataApiApplication.class)
@RunWith(MockitoJUnitRunner.class)
class CurrencyServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Saving db Data")
    void serviceSaveTest() throws CurrencyNotFoundException {
        String currencyName = "BitCoin";
        Optional<Currency> currency1 = Optional.of(new Currency(1L,"BitCoin",30d,35d,40d,45d));
        Currency currency2 = new Currency(1L,"BitCoin",30d,35d,50d,50d);

        //Mockito.doReturn(currency1).when(currencyRepository).findBycurrencyName(currencyName);

        Mockito.when(currencyRepository.findBycurrencyName(ArgumentMatchers.eq(currencyName))).thenReturn(currency1);
        Mockito.when(currencyRepository.save(ArgumentMatchers.refEq(currency2))).thenReturn(currency2);
        Currency result = currencyService.save(currency2);
        Assertions.assertEquals(currency2,result);
    }
    @Test
    @DisplayName("Getting Db Data")
    void getCurrency() throws CurrencyNotFoundException {
        String currencyName = "BitCoin";
        Optional<Currency> currency1 = Optional.of(new Currency(1L,"BitCoin",30d,35d,40d,45d));
        Mockito.when(currencyRepository.findBycurrencyName(ArgumentMatchers.eq(currencyName))).thenReturn(currency1);

        Currency result = currencyService.getCurrency(currencyName);
        Assertions.assertEquals(currency1.get(),result);

    }
}
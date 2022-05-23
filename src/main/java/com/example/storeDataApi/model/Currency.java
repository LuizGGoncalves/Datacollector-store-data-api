package com.example.storeDataApi.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.Optional;


@Data
@Entity
@Table
public class Currency {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String currencyName;
    @NotNull
    private Double brlOpen;
    @NotNull
    private Double usdOpen;
    @NotNull
    private Double brlClose;
    @NotNull
    private Double usdClose;

    public Currency() {
    }

    public Currency(Long id, String currencyName, Double brlOpen, Double usdOpen, Double brlClose, Double usdClose) {
        this.id = id;
        this.currencyName = currencyName;
        this.brlOpen = brlOpen;
        this.usdOpen = usdOpen;
        this.brlClose = brlClose;
        this.usdClose = usdClose;
    }
    public void upDateFrom(Currency newCurrency){
        Optional<Currency> optional = Optional.ofNullable(newCurrency);
        optional.map(Currency::getBrlOpen).ifPresent(this::setBrlOpen);
        optional.map(Currency::getUsdOpen).ifPresent(this::setUsdOpen);
        optional.map(Currency::getBrlClose).ifPresent(this::setBrlClose);
        optional.map(Currency::getUsdClose).ifPresent(this::setUsdClose);
    }
}

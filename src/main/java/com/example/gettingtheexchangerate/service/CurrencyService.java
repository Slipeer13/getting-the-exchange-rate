package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.entity.Currency;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<Currency> getCurrency(String date);

    Double getRateCurrency(String date, String currencyCode);
}

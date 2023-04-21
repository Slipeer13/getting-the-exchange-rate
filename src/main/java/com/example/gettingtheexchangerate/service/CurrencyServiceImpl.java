package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.CurrencyClient;
import com.example.gettingtheexchangerate.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Value("${base.currency}")
    private String base;

    @Autowired
    private CurrencyClient client;

    @Value("${currency.api_key}")
    private String currencyApiKey;

    @Override
    public ResponseEntity<Currency> getCurrency(String date) {
        return client.getCurrency(date, currencyApiKey, base);
    }

    @Override
    public Double getRateCurrency(String date, String currencyCode) {
        Map<String , Double> rates = Objects.requireNonNull(getCurrency(date).getBody()).getRates();
        if(rates.containsKey(currencyCode)) {
            return rates.get(currencyCode);
        } else {
            throw new NoSuchElementException(String.format("there is no such currency %s", currencyCode));
        }
    }
}

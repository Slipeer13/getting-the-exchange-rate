package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.CurrencyClient;
import com.example.gettingtheexchangerate.entity.Currency;
import com.example.gettingtheexchangerate.properties.PropertiesCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyClient client;
    @Autowired
    PropertiesCurrency propertiesCurrency;

    @Override
    public ResponseEntity<Currency> getCurrency(String date) {
        return client.getCurrency(date, propertiesCurrency.apiKey(), propertiesCurrency.base());
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

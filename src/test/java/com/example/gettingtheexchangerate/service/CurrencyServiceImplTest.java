package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.CurrencyClient;
import com.example.gettingtheexchangerate.entity.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceImplTest {

    @Value("${base.currency}")
    private String base;

    @Autowired
    private CurrencyClient client;

    @Value("${currency.api_key}")
    private String currencyApiKey;

    @Test
    void getCurrency() {
        ResponseEntity<Currency> currency = client.getCurrency("2023-01-01", currencyApiKey, base);
        assertEquals(currency.getStatusCode(), HttpStatusCode.valueOf(200));
        assertNotNull(currency.getBody());
        assertEquals(currency.getBody().getBase(), base);
    }
}
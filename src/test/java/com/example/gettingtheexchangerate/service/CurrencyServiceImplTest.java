package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.CurrencyClient;
import com.example.gettingtheexchangerate.entity.Currency;
import com.example.gettingtheexchangerate.properties.PropertiesCurrency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurrencyServiceImplTest {

    @Autowired
    private CurrencyClient client;
    @Autowired
    PropertiesCurrency propertiesCurrency;

    @Test
    void getCurrency() {
        String date = LocalDate.now(ZoneId.of("GMT")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ResponseEntity<Currency> currency = client.getCurrency(date, propertiesCurrency.apiKey(), propertiesCurrency.base());
        assertEquals(currency.getStatusCode(), HttpStatusCode.valueOf(200));
        assertNotNull(currency.getBody());
        assertEquals(currency.getBody().getBase(), propertiesCurrency.base());
    }
}
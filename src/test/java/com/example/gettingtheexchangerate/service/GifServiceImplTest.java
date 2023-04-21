package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.GifClient;
import com.example.gettingtheexchangerate.entity.Gif;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GifServiceImplTest {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    private GifClient gifClient;

    @Value("${gif.api_key}")
    private String gifApiKey;

    @Test
    void getGif() {
        String currencyCode = "EUR";
        LocalDate date = LocalDate.now();
        String today = formattedDate(date);
        String yesterday = formattedDate(date.minusDays(1));
        Double rateCurrencyNow = currencyService.getRateCurrency(today, currencyCode);
        Double rateCurrencyYesterday = currencyService.getRateCurrency(yesterday, currencyCode);
        assertNotNull(rateCurrencyNow);
        assertNotNull(rateCurrencyYesterday);
    }

    @Test
    void getRandomGif() {
        ResponseEntity<Gif> gif = gifClient.getRandomGif(gifApiKey, "rich");
        assertEquals(gif.getStatusCode(), HttpStatusCode.valueOf(200));
        assertNotNull(gif.getBody());
        assertEquals(gif.getBody().getData().get("type"), "gif");
    }

    private String formattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
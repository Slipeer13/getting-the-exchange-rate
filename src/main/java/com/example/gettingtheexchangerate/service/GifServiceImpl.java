package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.GifClient;
import com.example.gettingtheexchangerate.entity.Gif;
import com.example.gettingtheexchangerate.properties.PropertiesGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class GifServiceImpl implements GifService{

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private GifClient gifClient;
    @Autowired
    private PropertiesGif propertiesGif;

    @Override
    public ResponseEntity<Gif> getGif(String currencyCode) {
        return getRandomGif(getTag(currencyCode));
    }

    private String formattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private ResponseEntity<Gif> getRandomGif(String tag) {
        return gifClient.getRandomGif(propertiesGif.apiKey(), tag);
    }

    private String getTag(String currencyCode) {
        return isHigher(currencyCode) ? "rich" : "broke";
    }

    private boolean isHigher(String currencyCode) {
        LocalDate date = LocalDate.now(ZoneId.of("GMT"));
        String today = formattedDate(date);
        String yesterday = formattedDate(date.minusDays(1));
        Double rateCurrencyNow = currencyService.getRateCurrency(today, currencyCode);
        Double rateCurrencyYesterday = currencyService.getRateCurrency(yesterday, currencyCode);
        return rateCurrencyNow > rateCurrencyYesterday;
    }
}

package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.client.GifClient;
import com.example.gettingtheexchangerate.entity.Gif;
import com.example.gettingtheexchangerate.properties.PropertiesGif;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GifServiceImplTest {

    @Autowired
    GifService gifService;
    @Autowired
    private GifClient gifClient;
    @Autowired
    PropertiesGif propertiesGif;

    @Test
    void getGif() throws IOException {
        String currencyCode = "EUR";
        ResponseEntity<Gif> gif = gifService.getGif(currencyCode);
        assertNotNull(gif);
    }

    @Test
    void getRandomGif() {
        ResponseEntity<Gif> gif = gifClient.getRandomGif(propertiesGif.apiKey(), "rich");
        assertEquals(gif.getStatusCode(), HttpStatusCode.valueOf(200));
        assertNotNull(gif.getBody());
        assertEquals(gif.getBody().getData().get("type"), "gif");
    }
}
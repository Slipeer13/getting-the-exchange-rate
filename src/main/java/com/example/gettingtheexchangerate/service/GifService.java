package com.example.gettingtheexchangerate.service;

import com.example.gettingtheexchangerate.entity.Gif;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface GifService {

    ResponseEntity<Gif> getGif(String currencyCode) throws IOException;

}

package com.example.gettingtheexchangerate.controller;

import com.example.gettingtheexchangerate.entity.Gif;
import com.example.gettingtheexchangerate.exceptionHandling.IncorrectData;
import com.example.gettingtheexchangerate.service.GifService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Locale;

@RestController
@RequestMapping("/gif")
public class GifController {

    @Autowired
    GifService gifService;

    @GetMapping("/{currencyCode}")
    public ResponseEntity<Gif> getGif(@PathVariable @NotNull String currencyCode) throws IOException {
        return gifService.getGif(currencyCode.toUpperCase(Locale.ROOT));
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(Exception exception) {
        IncorrectData productIncorrectData =  new IncorrectData(exception.getMessage());
        return new ResponseEntity<>(productIncorrectData, HttpStatus.BAD_REQUEST);
    }
}

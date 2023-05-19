package com.example.gettingtheexchangerate.client;

import com.example.gettingtheexchangerate.entity.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif-service", url = "${gif.url}")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Gif> getRandomGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}


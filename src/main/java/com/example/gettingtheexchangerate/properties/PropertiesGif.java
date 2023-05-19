package com.example.gettingtheexchangerate.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "gif")
public record PropertiesGif(String url, String apiKey) {

}

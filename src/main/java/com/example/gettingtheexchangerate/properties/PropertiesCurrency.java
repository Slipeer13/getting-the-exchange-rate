package com.example.gettingtheexchangerate.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "currency")
public record PropertiesCurrency(String apiKey, String url, String base) {
}

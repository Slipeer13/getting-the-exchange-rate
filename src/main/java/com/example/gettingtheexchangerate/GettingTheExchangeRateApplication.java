package com.example.gettingtheexchangerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan("com.example.gettingtheexchangerate")
public class GettingTheExchangeRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GettingTheExchangeRateApplication.class, args);
    }

}

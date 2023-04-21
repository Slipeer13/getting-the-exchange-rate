package com.example.gettingtheexchangerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GettingTheExchangeRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GettingTheExchangeRateApplication.class, args);
    }

}

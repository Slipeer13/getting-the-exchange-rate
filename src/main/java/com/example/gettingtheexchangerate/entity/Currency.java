package com.example.gettingtheexchangerate.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Currency {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String , Double> rates;
}

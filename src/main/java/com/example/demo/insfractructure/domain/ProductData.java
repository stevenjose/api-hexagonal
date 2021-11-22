package com.example.demo.insfractructure.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductData {
    private String name;
    private double price;
    private String company;
}

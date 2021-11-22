package com.example.demo.insfractructure.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private int id;
    private ProductData productData;
}

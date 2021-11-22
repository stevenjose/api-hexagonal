package com.example.demo.insfractructure.ports.primary;

import com.example.demo.insfractructure.domain.Product;

import java.util.List;


public interface ProductService {
    Product addProduct(Product product);

    void deleteProduct(int idProduct);

    Product findProductById(int idProduct);

    List<Product> getAllProducts();
}

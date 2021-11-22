package com.example.demo.insfractructure.adapters.secondary;

import com.example.demo.insfractructure.domain.Product;
import com.example.demo.insfractructure.ports.secondary.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryMySQLDatabase implements ProductRepository {

    public static List<Product> products = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        if (products.add(product)){
            return product;
        }
        return null;
    }

    @Override
    public void deleteProduct(int idDeleteProduct) {
        products = products.stream()
                .filter(product -> product.getId() != idDeleteProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product findProductById(int idProduct) {

        products = products.stream()
                .filter(product -> product.getId() == idProduct)
                .collect(Collectors.toList());
        return products.get(0);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    public Product findByIdProduct(int idProduct) {
        List<Product> productSearch = new ArrayList<>();
        productSearch = products.stream()
                .filter(product -> product.getId() == idProduct)
                .collect(Collectors.toList());

        System.out.println(productSearch);

        return productSearch.get(0);

    }
}

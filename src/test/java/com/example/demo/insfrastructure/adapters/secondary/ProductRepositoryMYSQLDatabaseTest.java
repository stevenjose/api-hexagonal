package com.example.demo.insfrastructure.adapters.secondary;

import com.example.demo.insfractructure.adapters.secondary.ProductRepositoryMySQLDatabase;
import com.example.demo.insfractructure.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryMYSQLDatabaseTest {

    private ProductRepositoryMySQLDatabase sut = new ProductRepositoryMySQLDatabase();

    @AfterEach
    void restoreDatabase(){
        ProductRepositoryMySQLDatabase.products = new ArrayList<>();
    }

    @Test
    void addProduct(){
        final Product product = Product.builder().build();

        sut.addProduct(product);

        assertEquals(1, ProductRepositoryMySQLDatabase.products.size());
    }

    @Test
    void deleteProduct(){
        final int idProductDelete = 1;
        final Product product = Product.builder()
                .id(idProductDelete)
                .build();
        sut.addProduct(product);
        sut.deleteProduct(idProductDelete);
        assertEquals(0, ProductRepositoryMySQLDatabase.products.size());
    }

    @Test
    void findByIdProduct(){
        final int idProduct = 1;
        Product product = Product.builder()
                .id(idProduct)
                .build();
        sut.addProduct(product);
        Product productSearch = sut.findByIdProduct(idProduct);
        assertEquals(idProduct, productSearch.getId());
    }

    @Test
    void shouldReturnAllProduct(){
        Product product1 = Product.builder().id(1).build();
        Product product2 = Product.builder().id(1).build();
        Product product3 = Product.builder().id(1).build();
        sut.addProduct(product1);
        sut.addProduct(product2);
        sut.addProduct(product3);

        //List<Product> products = sut.getAllProducts();
        //assertEquals(3, products.size());
        assertEquals(3, sut.getAllProducts().size());

    }
}

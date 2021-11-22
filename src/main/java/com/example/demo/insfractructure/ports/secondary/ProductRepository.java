package com.example.demo.insfractructure.ports.secondary;

import com.example.demo.api.vo.ProductVO;
import com.example.demo.insfractructure.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    Product addProduct(Product product);

    void deleteProduct(int idDeleteProduct);

    Product findProductById(int idProduct);

    List<Product> getAllProducts();
}

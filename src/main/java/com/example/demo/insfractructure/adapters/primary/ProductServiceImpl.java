package com.example.demo.insfractructure.adapters.primary;

import com.example.demo.insfractructure.domain.Product;
import com.example.demo.insfractructure.ports.primary.ProductService;
import com.example.demo.insfractructure.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int idProduct) {
        productRepository.deleteProduct(idProduct);
    }

    @Override
    public Product findProductById(int idProduct) {
        return productRepository.findProductById(idProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }


}

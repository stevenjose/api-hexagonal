package com.example.demo.insfrastructure.adapters.primary;

import com.example.demo.insfractructure.adapters.primary.ProductServiceImpl;
import com.example.demo.insfractructure.domain.Product;
import com.example.demo.insfractructure.ports.primary.ProductService;
import com.example.demo.insfractructure.ports.secondary.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

 class ProductServiceImplTest {

    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ProductService sut = new ProductServiceImpl(productRepository);

    @Test
    void shouldCallRepositoryToSaveProduct() {
        Product product = Product.builder().build();
        sut.addProduct(product);
        verify(productRepository).addProduct(product);
    }


    @Test
     void shouldCallRepositoryToDeleteProduct() {
        final int idDeleteProduct = 1;
        sut.deleteProduct(idDeleteProduct);
        verify(productRepository).deleteProduct(idDeleteProduct);
    }

    @Test
     void shouldCallRepositoryToFindById() {
        final int idProduct = 1;
        sut.findProductById(idProduct);
        verify(productRepository).findProductById(idProduct);
    }

    @Test
     void shouldCallRepositoryToFindAll() {
        sut.getAllProducts();
        verify(productRepository).getAllProducts();
    }
}

package com.example.demo.api.rest;

import com.example.demo.api.converters.ProductConverter;
import com.example.demo.api.vo.ProductVO;
import com.example.demo.insfractructure.domain.Product;
import com.example.demo.insfractructure.ports.primary.ProductService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


class ProductControllerTest {

    private final ProductConverter productConverter = mock(ProductConverter.class);
    private final ProductService productService = mock(ProductService.class);
    private final ProductController sut = new ProductController(productConverter, productService);

    @Test
    void shouldCallServiceAddProduct(){
        ProductVO productVO = ProductVO.builder().build();
        Product product = Product.builder().build();
        when(productConverter.convertToVo(any())).thenReturn(productVO);
        when(productConverter.convertToDomain(any())).thenReturn(product);
        sut.addProduct(productVO);
        verify(productService).addProduct(product);
    }

    @Test
    void shouldCallServiceDeleteProduct(){
        final int idProduct = 1;
        sut.deleteProduct(idProduct);
        verify(productService).deleteProduct(idProduct);
    }

    @Test
    void shouldCallServiceProductFindById(){
        final int idProduct = 1;
        ProductVO productVO = ProductVO.builder().id(idProduct).build();
        when(productConverter.convertToVo(any())).thenReturn(productVO);
        sut.findProductById(idProduct);
        verify(productService).findProductById(idProduct);
    }

    @Test
    void shouldCallServiceGetAllProducts(){
        sut.getAllProducts();
        verify(productService).getAllProducts();
    }
}

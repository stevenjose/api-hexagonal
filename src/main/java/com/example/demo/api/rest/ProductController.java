package com.example.demo.api.rest;

import com.example.demo.api.converters.ProductConverter;
import com.example.demo.api.vo.ProductVO;
import com.example.demo.insfractructure.domain.Product;
import com.example.demo.insfractructure.ports.primary.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductConverter productConverter;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductVO> addProduct(@RequestBody ProductVO productVO) {
        final Product product = productConverter.convertToDomain(productVO);
        return ResponseEntity.of(Optional.of(productConverter.convertToVo(productService.addProduct(product))));
    }

    @DeleteMapping("{idToDelete}")
    public void deleteProduct(@PathVariable final int idToDelete) {
        productService.deleteProduct(idToDelete);
    }

    @GetMapping("{idProduct}")
    ResponseEntity<ProductVO> findProductById(@PathVariable int idProduct) {
        return ResponseEntity.of(Optional.of(productConverter.convertToVo(productService.findProductById(idProduct))));
    }

    @GetMapping
    ResponseEntity<List<ProductVO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductVO> productsVO = products.stream()
                .map(product -> productConverter.convertToVo(product))
                .collect(Collectors.toList());
        return ResponseEntity.of(Optional.of(productsVO));
    }
}

package com.joel.crudproducts.products.controller;

import com.joel.crudproducts.products.persistency.model.Product;
import com.joel.crudproducts.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registerProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long id){
        return this.productService.deleteProduct(id);
    }

}

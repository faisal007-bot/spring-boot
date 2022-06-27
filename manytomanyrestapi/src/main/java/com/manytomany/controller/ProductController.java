package com.manytomany.controller;

import com.manytomany.model.Product;
import com.manytomany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product product1 = productService.saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        List<Product> products1 = productService.saveProducts(products);
        return new ResponseEntity<>(products1, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

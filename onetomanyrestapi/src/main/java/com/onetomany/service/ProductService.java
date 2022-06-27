package com.onetomany.service;

import com.onetomany.model.Product;
import com.onetomany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        Product product1 = productRepository.saveAndFlush(product);
        return product1;
    }

    public List<Product> saveProducts(List<Product> products) {
        List<Product> products1 = productRepository.saveAllAndFlush(products);
        return products1;
    }

    public Product getProduct(int productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}

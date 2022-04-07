package com.virtuslab.internship.product;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {

    private final ProductDb productDb;

    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public Set<Product> getProducts() {
        return productDb.getAllProducts();
    }

    public Product getProduct(String name) {
        return productDb.getProduct(name);
    }

    public Set<Product> getProductsByCategory(String category) {
        return productDb.getProductsByCategory(category);
    }
}

package com.virtuslab.internship.basket;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.virtuslab.internship.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Component
public class Basket {
    private final List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}

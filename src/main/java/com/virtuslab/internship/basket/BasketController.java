package com.virtuslab.internship.basket;

import com.virtuslab.internship.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    private final Basket basket;

    public BasketController(Basket basket) {
        this.basket = basket;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = basket.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        basket.addProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        basket.deleteProduct(product);
    }







}

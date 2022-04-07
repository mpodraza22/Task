package com.virtuslab.internship.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Set<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<Set<Product>> getProductsByCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(productService.getProductsByCategory(category.toUpperCase(Locale.ROOT)), HttpStatus.OK);
    }

}

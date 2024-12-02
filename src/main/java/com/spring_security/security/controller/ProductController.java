package com.spring_security.security.controller;

import com.spring_security.security.model.Product;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = List.of(
                new Product("Nike Air Max", "Red", "10"),
                new Product("Nike Air Zoom", "Blue", "9"),
                new Product("Nike Revolution", "Black", "11"),
                new Product("Nike Pegasus", "White", "8"),
                new Product("Nike Infinity", "Gray", "7")
        );
        return ResponseEntity.ok(products);
    }
}
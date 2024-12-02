package com.spring_security.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final RestTemplate restTemplate;

    public ClientController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/products")
    public ResponseEntity<String> fetchProducts(@RequestHeader("Authorization") String token) {
        try {
            // Add JWT token to the headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);

            // Create the request
            RequestEntity<Void> request = new RequestEntity<>(headers, HttpMethod.GET, new URI("http://localhost:8080/api/products"));

            // Call the product endpoint
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);

            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching products: " + e.getMessage());
        }
    }
}

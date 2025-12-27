package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product p) {
        return new ResponseEntity<>(service.add(p), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product p) {

        return ResponseEntity.ok(service.update(id, p));
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Product>> byCategory(
            @PathVariable String name) {

        return ResponseEntity.ok(service.byCategory(name));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> byName(@PathVariable String name) {
        List<Product> list = service.byName(name);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No products found with name: " + name);
        }
        return ResponseEntity.ok(list);
    }
}

package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody(required = false) Category category) {
        if (category == null ||
            category.getCategoryName() == null ||
            category.getCategoryName().isEmpty()) {

            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(service.addCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Category> categories = service.getAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(
            @PathVariable Long id,
            @RequestBody Category category) {

        return ResponseEntity.ok(service.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page/{page}/{size}")
    public Page<Category> getPage(
            @PathVariable int page,
            @PathVariable int size) {

        return service.getCategoryPage(page, size);
    }
}

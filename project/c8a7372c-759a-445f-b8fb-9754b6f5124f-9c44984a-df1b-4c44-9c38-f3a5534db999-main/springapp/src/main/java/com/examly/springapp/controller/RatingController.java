package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Rating;
import com.examly.springapp.service.RatingService;

@RestController
@RequestMapping("/api/ratings")  
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    public ResponseEntity<Rating> add(@RequestBody Rating rating) {
        return new ResponseEntity<>(service.addRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll() {
        return ResponseEntity.ok(service.getAllRatings());
    }
}

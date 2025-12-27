package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<>(service.add(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User user) {

        return ResponseEntity.ok(service.update(id, user));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<?> byRole(@PathVariable String role) {
        List<User> list = service.byRole(role);

        if (list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No users found with role: " + role);
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/username/{username}/role/{role}")
    public ResponseEntity<List<User>> byUsernameRole(
            @PathVariable String username,
            @PathVariable String role) {

        return ResponseEntity.ok(service.byUsernameRole(username, role));
    }
}

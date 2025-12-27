package com.example.harispring.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userser;
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userser.saveUser(user);
    }
    // findById
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }


}
package com.example.harispring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.harispring.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepo;

    // code for saving the datas
    public User register(User user){
        return userrepo.save(user);
    }
    


    // code for findById
    // public Optional<User> findById(Long id){
    //     return userrepo.findById(id);
    // }
}

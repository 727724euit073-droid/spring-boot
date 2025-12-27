package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    public User add(User u) { return repo.save(u); }

    public List<User> getAll() { return repo.findAll(); }

    public User get(Long id) { return repo.findById(id).orElse(null); }

    public User update(Long id, User u) {
        u.setId(id);
        return repo.save(u);
    }

    public List<User> byRole(String role) {
        return repo.findByRole(role);
    }

    public List<User> byUsernameRole(String username, String role) {
        return repo.findByUsernameAndRole(username, role);
    }
}

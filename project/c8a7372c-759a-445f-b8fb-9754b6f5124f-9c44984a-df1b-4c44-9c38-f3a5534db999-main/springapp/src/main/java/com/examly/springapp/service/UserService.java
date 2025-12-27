package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.User;

public interface UserService {
    User add(User u);
    List<User> getAll();
    User get(Long id);
    User update(Long id, User u);
    List<User> byRole(String role);
    List<User> byUsernameRole(String username, String role);
}

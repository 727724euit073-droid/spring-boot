package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByRole(String role);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.role = :role")
    List<User> findByUsernameAndRole(String username, String role);
}

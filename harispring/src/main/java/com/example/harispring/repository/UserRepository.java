package com.example.harispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.harispring.entity.User;

public interface UserRepository extends JpaRepository <User,Long> {

}

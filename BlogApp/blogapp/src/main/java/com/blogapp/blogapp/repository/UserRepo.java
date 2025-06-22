package com.blogapp.blogapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.blogapp.entities.User;

public interface UserRepo extends JpaRepository <User, Integer>{
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

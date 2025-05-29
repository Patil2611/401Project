package com.blogapp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.blogapp.entities.User;

public interface UserRepo extends JpaRepository <User, Integer>{

}

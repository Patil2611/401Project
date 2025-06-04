package com.blogapp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.blogapp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

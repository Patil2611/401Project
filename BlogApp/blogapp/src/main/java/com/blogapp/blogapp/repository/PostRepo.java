package com.blogapp.blogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.blogapp.entities.Category;
import com.blogapp.blogapp.entities.Post;
import com.blogapp.blogapp.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
    
    List<Post> getAllPostByUser(User user);
    List<Post> getAllPostByCategory(Category category);
    
}

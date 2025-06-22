package com.blogapp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.blogapp.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
    
}

package com.blogapp.blogapp.services;

import java.util.List;

// import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.payloads.PostDto;

public interface PostService {

    // create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete
    void deletePost(Integer postId);

    //get all posts
    List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
     

    // Get post by id
    PostDto getPostById(Integer postId);

    // Get post by user 
    List<PostDto> getPostByUser(Integer userId, Integer pageNumber, Integer pageSize);

    // Get post by category
    List<PostDto> getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

    // Search post
    List<PostDto> searchPost(String keyword, Integer pageNumber, Integer pageSize);
}

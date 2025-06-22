package com.blogapp.blogapp.services;

import java.util.List;

// import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.payloads.PostDto;
import com.blogapp.blogapp.payloads.PostResponse;

public interface PostService {

    // create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
     

    // Get post by id
    PostDto getPostById(Integer postId);

    // Get post by user 
    List<PostDto> getPostByUser(Integer userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // Get post by category
    PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // Search post
    List<PostDto> searchPost(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}

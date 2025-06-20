package com.blogapp.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.blogapp.payloads.ApiResponse;
import com.blogapp.blogapp.payloads.PostDto;
import com.blogapp.blogapp.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<ApiResponse> addPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        PostDto post = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(new ApiResponse("post created successfully", true, post), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getPostByUserId(
        @PathVariable Integer userId,
        @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
        ) {
        List<PostDto> posts = postService.getPostByUser(userId, pageNumber, pageSize);
        return new ResponseEntity<>(new ApiResponse("Data fetch successfully", true, posts), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse> getPostByCategoryId(
        @PathVariable Integer categoryId,
        @RequestParam (value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
        @RequestParam (value = "pageSize", defaultValue = "10", required = false) Integer pageSize
        ) {
        List<PostDto> posts = postService.getPostByCategory(categoryId, pageNumber, pageSize);
        return new ResponseEntity<>(new ApiResponse("Data fetch successfully", true, posts), HttpStatus.OK);
    }

    @GetMapping("/search/{searchValue}")
    public ResponseEntity<ApiResponse> getSearchPost(
        @PathVariable String searchValue,
        @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
        ) {
        List<PostDto> posts = postService.searchPost(searchValue, pageNumber, pageSize);
        return new ResponseEntity<>(new ApiResponse("Date fetch successfully", true, posts), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPosts(
        @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
    ){
        List<PostDto> posts = postService.getAllPost(pageNumber, pageSize);
        return new ResponseEntity<>(new ApiResponse("Post fetch successfully", true, posts), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Deleted successfully", true, null), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> getPostById(@PathVariable Integer postId){
        PostDto post = postService.getPostById(postId);
        return  new ResponseEntity<>(new ApiResponse("Post Fetch successfully", true, post), HttpStatus.OK);
    }


    @PutMapping("/update/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto post = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(new ApiResponse("Data Updated", true, post), HttpStatus.OK);
    }

}
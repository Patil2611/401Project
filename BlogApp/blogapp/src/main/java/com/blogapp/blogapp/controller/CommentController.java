package com.blogapp.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.blogapp.payloads.ApiResponse;
import com.blogapp.blogapp.payloads.CommentDto;
import com.blogapp.blogapp.services.CommentService;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create/{postId}")
    public ResponseEntity<ApiResponse> createComment(@RequestBody CommentDto commentDto, @PathVariable("postId") Integer postId) {
        CommentDto comment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(new ApiResponse("Comment added successfull", true, comment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteById(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfull", true, null), HttpStatus.OK);
    }

    @GetMapping("/getComment/{id}")
    public ResponseEntity<ApiResponse> getComment(@PathVariable Integer id,
    @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, 
    @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
    @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir
    ) {
        List<CommentDto> comment = commentService.getAllCommentByPost(id, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(new ApiResponse("Comment fetch successfull", true, comment), HttpStatus.OK);
    }
}

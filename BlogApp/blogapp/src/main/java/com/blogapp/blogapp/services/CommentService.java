package com.blogapp.blogapp.services;

import java.util.List;

import com.blogapp.blogapp.payloads.CommentDto;

public interface CommentService {
    public void deleteById(Integer id);
    public List<CommentDto> getAllCommentByPost(Integer postId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    public CommentDto createComment(CommentDto commentDto, Integer postId);
}

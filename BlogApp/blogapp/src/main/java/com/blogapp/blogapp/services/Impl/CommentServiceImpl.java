package com.blogapp.blogapp.services.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blogapp.blogapp.entities.Comment;
import com.blogapp.blogapp.entities.Post;
import com.blogapp.blogapp.exceptions.ResourceNotFoundException;
import com.blogapp.blogapp.payloads.CommentDto;
import com.blogapp.blogapp.repository.CommentRepo;
import com.blogapp.blogapp.repository.PostRepo;
import com.blogapp.blogapp.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;
    
    @Override
    public void deleteById(Integer id) {
        Comment comment = commentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post Not Found", "Id ", id));
        commentRepo.delete(comment);
    }

    @Override
    public List<CommentDto> getAllCommentByPost(Integer postId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post Not Found ", " Id ", postId));
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable p = PageRequest.of(pageNumber, pageSize, sort);
        List<CommentDto> comments = commentRepo.findAll(p).stream().filter((c)-> c.getPost() == post).map((c)-> modelMapper.map(c, CommentDto.class)).toList();
        return comments;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found", "Id ", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        commentRepo.save(comment);
        return commentDto;
    }

}

package com.blogapp.blogapp.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.blogapp.blogapp.entities.Category;
import com.blogapp.blogapp.entities.Post;
import com.blogapp.blogapp.entities.User;
import com.blogapp.blogapp.exceptions.ResourceNotFoundException;
import com.blogapp.blogapp.payloads.PostDto;
import com.blogapp.blogapp.payloads.PostResponse;
import com.blogapp.blogapp.repository.PostRepo;
import com.blogapp.blogapp.repository.CategoryRepo;
import com.blogapp.blogapp.repository.UserRepo;
import com.blogapp.blogapp.services.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {


        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found ", " Id ", categoryId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category not Found ", " id ", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setImage("default.png");
        post.setCreatedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        postRepo.save(post);
        return postDto;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post Not Found ", " id ", postId));
        postRepo.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("asc") ? org.springframework.data.domain.Sort.by(sortBy).ascending() : org.springframework.data.domain.Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePosts = postRepo.findAll(pageable);
        List<PostDto> posts = postRepo.findAll(pageable)
        .stream().map((post) -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(posts);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("asc") ? org.springframework.data.domain.Sort.by(sortBy).ascending() : org.springframework.data.domain.Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePosts = postRepo.findAll(pageable);

        List<PostDto> posts = postRepo.findAll(pageable)
        .stream().filter((post)-> post.getCategory().getId() == categoryId).collect(Collectors.toList())
        .stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(posts);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post Not Found ", " id ", postId));
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("asc") ? org.springframework.data.domain.Sort.by(sortBy).ascending() : org.springframework.data.domain.Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        List<PostDto> posts = postRepo.findAll(pageable).stream().filter((post)-> post.getUser().getId() == userId).collect(Collectors.toList()).stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return posts;
    }

    @Override
    public List<PostDto> searchPost(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        sort = sortDir.equalsIgnoreCase("asc") ? org.springframework.data.domain.Sort.by(sortBy).ascending() : org.springframework.data.domain.Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        List<PostDto> posts = postRepo.findAll(pageable).toList()
        .stream().map((post)-> modelMapper.map(post, PostDto.class)).toList()
        .stream().filter((post)-> post.getTitle().toLowerCase().contains(keyword.toLowerCase())
        || post.getContent().toLowerCase().contains(keyword.toLowerCase())
        ).toList();
        return posts;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", " Id ", postId));
        post.setAuthor(postDto.getAuthor());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImage(postDto.getImage());
        postRepo.save(post);
        return postDto;
    }
}

package com.blogapp.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.blogapp.payloads.ApiResponse;
import com.blogapp.blogapp.payloads.CategoryDto;
import com.blogapp.blogapp.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto dto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse("Data insert successfully", true, dto), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Integer id){
        CategoryDto dto = this.categoryService.getCategoryById(id);
        return new ResponseEntity<>(new ApiResponse("Result Found", true, dto), HttpStatus.OK);
    }

    @GetMapping("get/all")
    public ResponseEntity<ApiResponse> getAllCategories(){
        List<CategoryDto> dto = this.categoryService.getAllCategories();
        return new ResponseEntity<>(new ApiResponse("Result Fetched", true, dto), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        CategoryDto dto = this.categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(new ApiResponse("Category data updated", true, dto), HttpStatus.OK);
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<ApiResponse> patchCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        CategoryDto dto = this.categoryService.patchCategory(categoryDto, id);
        return new ResponseEntity<>(new ApiResponse("Category data updated", true, dto), HttpStatus.OK);
    }
}

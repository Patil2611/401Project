package com.blogapp.blogapp.services;

import java.util.List;

import com.blogapp.blogapp.payloads.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    void deleteCategory(Integer id);
    CategoryDto patchCategory(CategoryDto categoryDto, Integer id);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Integer id);
}

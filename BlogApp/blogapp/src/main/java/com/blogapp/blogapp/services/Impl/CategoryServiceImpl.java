package com.blogapp.blogapp.services.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.blogapp.entities.Category;
import com.blogapp.blogapp.payloads.CategoryDto;
import com.blogapp.blogapp.repository.CategoryRepo;
import com.blogapp.blogapp.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        // CategoryDto dto = ;
        CategoryDto dto = this.modelMapper.map(this.categoryRepo.save(category), CategoryDto.class);
        // 
        return dto;
    }

    @Override
    public void deleteCategory(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoryDto patchCategory(CategoryDto categoryDto, Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}

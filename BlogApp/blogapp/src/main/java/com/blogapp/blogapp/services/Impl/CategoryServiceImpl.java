package com.blogapp.blogapp.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogapp.blogapp.entities.Category;
import com.blogapp.blogapp.exceptions.ResourceNotFoundException;
import com.blogapp.blogapp.payloads.CategoryDto;
import com.blogapp.blogapp.repository.CategoryRepo;
import com.blogapp.blogapp.services.CategoryService;

import jakarta.validation.Valid;
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
        List<Category> category = this.categoryRepo.findAll();
        List<CategoryDto> dtoList = category.stream().map(c -> this.modelMapper.map(c, CategoryDto.class)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category ", " id", id));
        CategoryDto dto = this.modelMapper.map(category, CategoryDto.class);
        return dto;
    }

    @Override
    public CategoryDto patchCategory(CategoryDto categoryDto, Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category ", " id", id));
        
        if (categoryDto.getTitle() != null) {
            category.setTitle(categoryDto.getTitle());
        }

        if (categoryDto.getDescription() != null) {
            category.setDescription(categoryDto.getDescription());
        }
        
        CategoryDto tempDto = this.modelMapper.map(category, CategoryDto.class);
        return tempDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category Not Found", " id", id));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        categoryDto.setId(category.getId());
        this.categoryRepo.save(category);
        return categoryDto;
    }

    
}

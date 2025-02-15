package org.example.onlineshop.Services;

import org.example.onlineshop.Services.impl.CategoryInterface;
import org.example.onlineshop.dto.Category.CategoryDtoRequest;
import org.example.onlineshop.dto.Category.CategoryDtoResponse;
import org.example.onlineshop.entity.Category;
import org.example.onlineshop.repository.CategoryRepository;
import org.example.onlineshop.util.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServices implements CategoryInterface {
    final
    CategoryRepository categoryRepository;
    final
    CategoryMapper categoryMapper;

    public CategoryServices(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDtoResponse CreateNewCategory(CategoryDtoRequest categoryDtoRequest) {
        Category category = categoryMapper.toCategory(categoryDtoRequest);
        categoryRepository.save(category);
        CategoryDtoResponse response = categoryMapper.toResponse(category);
        System.out.println(response);
        return response;

    }

    @Override
    public List<CategoryDtoResponse> GetAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList()); // Fix: Collecting into a List
    }

}

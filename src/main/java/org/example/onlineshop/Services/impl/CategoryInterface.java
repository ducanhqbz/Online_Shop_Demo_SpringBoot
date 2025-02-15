package org.example.onlineshop.Services.impl;

import org.example.onlineshop.dto.Category.CategoryDtoRequest;
import org.example.onlineshop.dto.Category.CategoryDtoResponse;

import java.util.List;

public interface CategoryInterface {
    public CategoryDtoResponse CreateNewCategory(CategoryDtoRequest categoryDtoRequest);
public List<CategoryDtoResponse> GetAllCategories();
}

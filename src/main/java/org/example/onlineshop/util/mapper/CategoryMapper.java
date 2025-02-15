package org.example.onlineshop.util.mapper;

import org.example.onlineshop.dto.Category.CategoryDtoRequest;
import org.example.onlineshop.dto.Category.CategoryDtoResponse;
import org.example.onlineshop.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
public Category toCategory(CategoryDtoRequest categoryDtoRequest) {
    return Category.builder().categoryName(categoryDtoRequest.getCategoryName()).build();

}
    public static CategoryDtoResponse toResponse(Category category) {
        return CategoryDtoResponse.builder().id(category.getId()).categoryName(category.getCategoryName()).build();

    }


}

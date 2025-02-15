package org.example.onlineshop.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.Exception.OnlineShopException;
import org.example.onlineshop.Services.CategoryServices;
import org.example.onlineshop.dto.Category.CategoryDtoRequest;
import org.example.onlineshop.dto.Category.CategoryDtoResponse;
import org.example.onlineshop.entity.Category;
import org.example.onlineshop.repository.CategoryRepository;
import org.example.onlineshop.util.Constant;
import org.example.onlineshop.util.mapper.CategoryMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(Constant.API_VERSION)
public class CategoryController {
    CategoryServices categoryServices;
    private final CategoryRepository categoryRepository;

    @PostMapping("/CreateNewCategory")
    public CategoryDtoResponse createCategory(@RequestBody CategoryDtoRequest request) {
        System.out.println(request);
        CategoryDtoResponse response = categoryServices.CreateNewCategory(request);
        System.out.println(response);
        return response;
    }
    @GetMapping("/GetAllCategory")
public List<CategoryDtoResponse> getAllCategory() {

        return  categoryServices.GetAllCategories();
}

@GetMapping("/GetCategoryId/{id}")
    public CategoryDtoResponse getCategoryById(@PathVariable(required = false) Integer id) {
    if (id == null || id <= 0) {
        throw OnlineShopException.NotFound("Invalid category ID");
    }

    Category category = categoryRepository.findById(id)
            .orElseThrow(() -> OnlineShopException.NotFound("Category does not exist"));

    return CategoryMapper.toResponse(category);
    }

}

package org.example.onlineshop.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.Exception.OnlineShopException;
import org.example.onlineshop.Services.ProductServices;

import org.example.onlineshop.dto.Product.ProductDtoResponse;
import org.example.onlineshop.dto.Product.ProductDtoFilter;
import org.example.onlineshop.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(Constant.API_VERSION)
public class ProductController {
    @Autowired
    ProductServices productServices;
    @GetMapping("/GetProductByID/{id}")
    public ProductDtoResponse GetAllProduct(@PathVariable(required = false) Integer id) {
        if (id == null || id <= 0) {
            throw OnlineShopException.NotFound("Invalid category ID");
        }

return productServices.GetProductByID(id);
    }

        @GetMapping("/filter")
    public List<ProductDtoResponse> Filter(@ModelAttribute ProductDtoFilter filter){return productServices.Filter(filter);}
}

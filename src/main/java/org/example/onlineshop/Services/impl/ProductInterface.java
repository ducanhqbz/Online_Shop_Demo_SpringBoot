package org.example.onlineshop.Services.impl;

import org.example.onlineshop.dto.Product.ProductDtoFilter;
import org.example.onlineshop.dto.Product.ProductDtoResponse;

import java.util.List;

public interface ProductInterface {
    public ProductDtoResponse GetProductByID(int id);
public List<ProductDtoResponse> Filter(ProductDtoFilter filter);
}

package org.example.onlineshop.util.mapper;

import org.example.onlineshop.dto.Product.ProductDtoResponse;
import org.example.onlineshop.entity.Product;

public class ProductMapper {

    public static ProductDtoResponse ToResponse(Product product) {
        return ProductDtoResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .summary(product.getSummary())
                .description(product.getDescription())
                .availability(product.getAvailability())
                .category(product.getCategory())
                .build();
    }

}

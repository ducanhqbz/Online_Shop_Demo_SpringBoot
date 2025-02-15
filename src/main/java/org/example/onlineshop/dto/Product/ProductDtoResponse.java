package org.example.onlineshop.dto.Product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.entity.Category;
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDtoResponse {

    private String name;

    private double price;

    private int quantity;

    private String summary;

    private String description;

    private String availability;


    private Category category;
}

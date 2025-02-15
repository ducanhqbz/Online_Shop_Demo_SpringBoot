package org.example.onlineshop.dto.Category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDtoRequest {
    int id ;
    String categoryName;
}

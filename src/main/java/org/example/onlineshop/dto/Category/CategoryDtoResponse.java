package org.example.onlineshop.dto.Category;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class CategoryDtoResponse {
    int id ;
    String categoryName;
}

package org.example.onlineshop.dto.Product;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.util.Constant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDtoFilter {
    Integer pageIndex = 1;
    Integer pageSize = Constant.Default_PageSize;
    String keyword;
    Integer categoryId;
    Double priceFrom = 0d;
    Double priceTo = Double.MAX_VALUE;
    String sortByPrice;
    String name = "";
    Boolean availability;
}

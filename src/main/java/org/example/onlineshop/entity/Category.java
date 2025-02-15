package org.example.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_categories")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    int id;

    @Column(name = "category_name")
    String categoryName;

      @OneToMany (mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
      @JsonManagedReference
      @JsonIgnore
    List<Product> productList;


}

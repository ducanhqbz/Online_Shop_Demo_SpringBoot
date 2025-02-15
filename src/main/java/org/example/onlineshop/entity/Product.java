package org.example.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*; // ✅ Đúng import!
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "summary")
    private String summary;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "availability")
    private String availability;
    @Column(name = "specification")
    private String specification;

    @ManyToOne
    @ToString.Exclude

    @JoinColumn(name = "category_id", nullable = false) // ✅ Đặt đúng tên khóa ngoại
    @JsonBackReference
    private Category category;
}

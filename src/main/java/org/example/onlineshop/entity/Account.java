package org.example.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_account")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
    @Column(unique = true, nullable = false)
    String username;
    @Column(unique = true, nullable = false)
    String email;
    @Column(unique = true, nullable = false)
    String password;

}

package org.example.onlineshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenPayLoad {
    int accountId;
    String username;
}

package org.example.onlineshop.dto.Account;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class AccountDtoResponse {
    int id;
    String username;
    String email;
}

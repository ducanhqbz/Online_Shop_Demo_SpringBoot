package org.example.onlineshop.dto.Account;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountDto {
    int id;
    String username;
    String email;
}

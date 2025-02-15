package org.example.onlineshop.dto.Account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountDtoCreate {

    String username;
    String email;
    String password;
}

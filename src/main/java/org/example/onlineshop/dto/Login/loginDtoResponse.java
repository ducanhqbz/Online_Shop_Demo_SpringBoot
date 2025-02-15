package org.example.onlineshop.dto.Login;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.dto.Account.AccountDtoResponse;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class loginDtoResponse {

    String Accesstoken;
    AccountDtoResponse accountDtoResponse;

}

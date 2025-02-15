package org.example.onlineshop.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.Services.AccountServices;
import org.example.onlineshop.dto.Account.AccountDtoCreate;
import org.example.onlineshop.dto.Account.AccountDtoResponse;
import org.example.onlineshop.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_VERSION)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

 AccountServices accountServices;

    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @PostMapping("/CreateNew")
    public AccountDtoResponse CreateNewAccount(@RequestBody AccountDtoCreate account) throws Exception {
        if (account == null || account.getUsername() == null || account.getPassword() == null || account.getEmail() == null) {
            throw new NullPointerException("Thiếu thông tin tài khoản!");
        }

        return accountServices.CreateAccount(account);
    }


}

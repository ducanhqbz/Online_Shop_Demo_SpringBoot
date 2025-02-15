package org.example.onlineshop.Services.impl;

import org.example.onlineshop.dto.Account.AccountDto;
import org.example.onlineshop.dto.Account.AccountDtoCreate;
import org.example.onlineshop.dto.Account.AccountDtoResponse;
import org.example.onlineshop.dto.Login.LoginDtoRequest;
import org.example.onlineshop.dto.Login.loginDtoResponse;
import org.example.onlineshop.entity.Account;

public interface AccountInteface {
    public AccountDtoResponse CreateAccount(AccountDtoCreate Account);
    public loginDtoResponse Login(LoginDtoRequest loginDtoRequest);

}

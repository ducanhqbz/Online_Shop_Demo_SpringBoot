package org.example.onlineshop.util.mapper;

import org.example.onlineshop.dto.Account.AccountDtoCreate;
import org.example.onlineshop.dto.Account.AccountDtoResponse;
import org.example.onlineshop.entity.Account;
import org.example.onlineshop.entity.TokenPayLoad;


public class AccountMapper {

    public static Account toAccount(AccountDtoCreate accountDtoCreate) {
        return Account.builder().
                email(accountDtoCreate.getEmail()).
                password(accountDtoCreate.getPassword()).
                username(accountDtoCreate.getUsername()).
                build();
    }

    public static AccountDtoResponse toAccountDtoResponse(Account account) {

        return AccountDtoResponse.builder().id(account.getId()).
                email(account.getEmail()).
                username(account.getUsername()).
                build();
    }


}

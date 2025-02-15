package org.example.onlineshop.Services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.Services.impl.AccountInteface;
import org.example.onlineshop.dto.Account.AccountDtoCreate;
import org.example.onlineshop.dto.Account.AccountDtoResponse;
import org.example.onlineshop.dto.Login.LoginDtoRequest;
import org.example.onlineshop.dto.Login.loginDtoResponse;
import org.example.onlineshop.entity.Account;
import org.example.onlineshop.entity.TokenPayLoad;
import org.example.onlineshop.repository.AccountRepository;
import org.example.onlineshop.util.JwtTokenUtil;
import org.example.onlineshop.util.mapper.AccountMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServices implements AccountInteface {
    private final AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenUtil jwtTokenUtil;

    public AccountServices(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @Override
    public AccountDtoResponse CreateAccount(AccountDtoCreate Account) {
        Account account = AccountMapper.toAccount(Account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);

        return AccountMapper.toAccountDtoResponse(account);
    }

    @Override
    public loginDtoResponse Login(LoginDtoRequest loginDtoRequest) {
Account account =accountRepository.findByUsername(loginDtoRequest.getUsername());
boolean match = passwordEncoder.matches(loginDtoRequest.getPassword(), account.getPassword());
if (!match) {throw new RuntimeException();}
int expriedtime = 24*60*60*1000;
String jwt = jwtTokenUtil.generateToken(TokenPayLoad.builder().accountId(account.getId()).username(account.getUsername()).build(),expriedtime);
return loginDtoResponse.builder().accountDtoResponse(AccountMapper.toAccountDtoResponse(account)).Accesstoken(jwt).build();
    }
}

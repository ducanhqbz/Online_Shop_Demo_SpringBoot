package org.example.onlineshop.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.Services.AccountServices;
import org.example.onlineshop.dto.Login.LoginDtoRequest;
import org.example.onlineshop.dto.Login.loginDtoResponse;

import org.example.onlineshop.util.Constant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(Constant.API_VERSION)
public class AuthenticationController {
AccountServices accountServices;
@PostMapping("/login")
public loginDtoResponse login(@RequestBody LoginDtoRequest login){
   return accountServices.Login(login);
}

}

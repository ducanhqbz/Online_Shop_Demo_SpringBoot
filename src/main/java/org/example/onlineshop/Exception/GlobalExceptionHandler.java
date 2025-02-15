package org.example.onlineshop.Exception;

import org.example.onlineshop.entity.MessageError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(OnlineShopException.class)
    public ResponseEntity<MessageError> onlineShopException(OnlineShopException e) {

    return new ResponseEntity<>(e.getError(),e.getHttpStatus());
}

}

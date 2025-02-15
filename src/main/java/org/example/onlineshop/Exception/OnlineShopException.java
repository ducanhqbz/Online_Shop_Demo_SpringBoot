package org.example.onlineshop.Exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.onlineshop.entity.MessageError;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OnlineShopException extends RuntimeException {
    HttpStatus httpStatus;
    MessageError error;

    public static OnlineShopException NotFound(String message) {

        return OnlineShopException.builder().httpStatus(HttpStatus.NOT_FOUND).error(MessageError.builder().statusCode(404).message(message).build()).build();
    }
}

package org.example.onlineshop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MessageError {
    private int statusCode;
    private String message;
}

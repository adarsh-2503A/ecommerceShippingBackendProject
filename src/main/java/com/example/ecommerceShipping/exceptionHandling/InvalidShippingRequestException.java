package com.example.ecommerceShipping.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidShippingRequestException extends RuntimeException {
    public InvalidShippingRequestException(String message) {
        super(message);
    }
}
package com.example.product.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RestException {
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}

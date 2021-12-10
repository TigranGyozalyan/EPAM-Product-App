package com.example.product.app.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
public class RestException extends RuntimeException {

    private Map<String, String> errorList;
    private HttpStatus status;

    public RestException(Map<String, String> errorList, HttpStatus status) {
        this.errorList = errorList;
        this.status = status;
    }

    public RestException(String field, String message, HttpStatus status) {
        this.errorList = Map.of(
                field, message
        );
        this.status = status;
    }

    public RestException(HttpStatus status) {
        this.errorList = Collections.emptyMap();
        this.status = status;
    }

}

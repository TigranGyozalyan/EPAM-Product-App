package com.example.product.app.validation;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductValidator {

    public void validate(CreateProductDto createProductDto) {
        Map<String, String> errorMap = new HashMap<>();

        if (createProductDto.getName() == null || createProductDto.getName().trim().isEmpty()) {
            errorMap.put("name", "Invalid name");
        }

        if (createProductDto.getPrice() == null || createProductDto.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            errorMap.put("price", "Invalid price");
        }

        if(!errorMap.isEmpty()) {
            throw new RestException(errorMap, HttpStatus.BAD_REQUEST);
        }

    }

}

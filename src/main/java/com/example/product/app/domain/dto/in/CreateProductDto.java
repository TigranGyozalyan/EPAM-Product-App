package com.example.product.app.domain.dto.in;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDto {

    private String name;
    private BigDecimal price;

}

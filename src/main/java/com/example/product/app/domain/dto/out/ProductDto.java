package com.example.product.app.domain.dto.out;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private BigDecimal price;

}

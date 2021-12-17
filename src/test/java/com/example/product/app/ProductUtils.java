package com.example.product.app;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.domain.entity.Product;

import java.math.BigDecimal;

public class ProductUtils {

    public static CreateProductDto getValidProductCreateDto() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName("Test");
        dto.setPrice(BigDecimal.valueOf(33.22));

        return dto;
    }

    public static CreateProductDto getInvalidProductCreateDto() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName(" ");
        dto.setPrice(BigDecimal.valueOf(-3.2));

        return dto;
    }

    public static Product getProductEntity() {
        Product product = new Product();

        product.setId(22);
        product.setName("Test name");
        product.setPrice(BigDecimal.ONE);

        return product;
    }

}

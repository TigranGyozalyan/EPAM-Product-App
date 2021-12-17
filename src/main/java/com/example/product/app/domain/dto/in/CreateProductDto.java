package com.example.product.app.domain.dto.in;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Data
@FieldNameConstants
public class CreateProductDto {

    private String name;
    private BigDecimal price;

}

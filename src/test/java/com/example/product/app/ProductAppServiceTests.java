package com.example.product.app;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

@DataJpaTest
@Import(ServiceImplTestConfiguration.class)
class ProductAppServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    void should_create_entity() {
        var createDto = getValidProductCreateDto();
        var result = productService.create(createDto);

        Assertions.assertEquals(result.getName(), createDto.getName());
    }

    private CreateProductDto getValidProductCreateDto() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName("Test");
        dto.setPrice(BigDecimal.valueOf(33.22));

        return dto;
    }

}

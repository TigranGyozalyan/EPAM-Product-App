package com.example.product.app;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.exception.RestException;
import com.example.product.app.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductAppServiceTests {

    private final Integer PRODUCT_ID = 1;

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void should_find_entity_by_id() {
        var result = productService.getById(PRODUCT_ID);

        Assertions.assertEquals(PRODUCT_ID, result.getId());
    }

    @Test
    void should_find_products() {
        var result = productService.getAll();

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void should_create_product() {
        var createDto = getValidProductCreateDto();
        var result = productService.create(createDto);

        Assertions.assertEquals(result.getName(), createDto.getName());
        Assertions.assertEquals(result.getPrice(), createDto.getPrice());
    }

    @Test
    void should_fail_to_create_product() {
        RestException exception = Assertions.assertThrows(RestException.class, () -> {
            var createDto = getInvalidProductCreateDto();
            productService.create(createDto);
        });

        Assertions.assertFalse(exception.getErrorList().isEmpty());
    }

    private CreateProductDto getValidProductCreateDto() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName("Test");
        dto.setPrice(BigDecimal.valueOf(33.22));

        return dto;
    }

    private CreateProductDto getInvalidProductCreateDto() {
        CreateProductDto dto = new CreateProductDto();
        dto.setName(" ");
        dto.setPrice(BigDecimal.valueOf(-3.2));

        return dto;
    }

}

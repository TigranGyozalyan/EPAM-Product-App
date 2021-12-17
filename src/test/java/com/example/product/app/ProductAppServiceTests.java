package com.example.product.app;

import com.example.product.app.exception.RestException;
import com.example.product.app.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductAppServiceTests {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void should_find_entity_by_id() {
        Integer id = 1;
        var result = productService.getById(id);

        Assertions.assertEquals(id, result.getId());
    }

    @Test
    void should_find_products() {
        var result = productService.getAll();

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void should_create_product() {
        var createDto = ProductUtils.getValidProductCreateDto();
        var result = productService.create(createDto);

        Assertions.assertEquals(result.getName(), createDto.getName());
        Assertions.assertEquals(result.getPrice(), createDto.getPrice());
    }

    @Test
    void should_fail_to_create_product() {
        RestException exception = Assertions.assertThrows(RestException.class, () -> {
            var createDto = ProductUtils.getInvalidProductCreateDto();
            productService.create(createDto);
        });

        Assertions.assertFalse(exception.getErrorList().isEmpty());
    }

}

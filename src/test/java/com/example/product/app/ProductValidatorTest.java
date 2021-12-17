package com.example.product.app;

import com.example.product.app.domain.dto.in.CreateProductDto;
import com.example.product.app.exception.RestException;
import com.example.product.app.validation.ProductValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductValidatorTest {

    @Autowired
    private ProductValidator validator;

    @Test
    public void should_catch_errors() {
        var dto = ProductUtils.getInvalidProductCreateDto();
        RestException exception = Assertions.assertThrows(RestException.class, () -> validator.validate(dto));

        var errorMap = exception.getErrorList();
        Assertions.assertAll(
            () -> Assertions.assertTrue(errorMap.containsKey(CreateProductDto.Fields.name)),
            () -> Assertions.assertTrue(errorMap.containsKey(CreateProductDto.Fields.price))
        );

    }

    @Test
    public void should_pass_with_no_exception() {
        Assertions.assertDoesNotThrow(() -> validator.validate(ProductUtils.getValidProductCreateDto()));
    }

}

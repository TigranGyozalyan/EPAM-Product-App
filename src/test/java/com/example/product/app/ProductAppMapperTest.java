package com.example.product.app;

import com.example.product.app.mapper.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductAppMapperTest {

    @Autowired
    private Mapper mapper;

    @Test
    public void should_map_to_entity() {
        var dto = ProductUtils.getValidProductCreateDto();

        var mappedResult = mapper.toEntity(dto);
        Assertions.assertAll(
            () -> Assertions.assertEquals(mappedResult.getName(), dto.getName()),
            () -> Assertions.assertEquals(mappedResult.getPrice(), dto.getPrice())
        );
    }

    @Test
    public void should_map_to_dto() {
        var entity = ProductUtils.getProductEntity();

        var mappedResult = mapper.toDto(entity);
        Assertions.assertAll(
            () -> Assertions.assertEquals(mappedResult.getId(), entity.getId()),
            () -> Assertions.assertEquals(mappedResult.getName(), entity.getName()),
            () -> Assertions.assertEquals(mappedResult.getPrice(), entity.getPrice())
        );
    }

}

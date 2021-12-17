package com.example.product.app.mapper;

import com.example.product.app.domain.dto.in.CreateProductDto;
import com.example.product.app.domain.dto.out.ProductDto;
import com.example.product.app.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    public Product toEntity(CreateProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        return dto;
    }

}

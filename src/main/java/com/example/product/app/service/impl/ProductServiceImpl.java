package com.example.product.app.service.impl;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.domain.dto.ProductDto;
import com.example.product.app.domain.entity.Product;
import com.example.product.app.exception.NotFoundException;
import com.example.product.app.repository.ProductRepository;
import com.example.product.app.service.ProductService;
import com.example.product.app.validation.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductValidator validator;

    @Override
    public ProductDto getById(Integer id) {
        return repository.findById(id)
            .map(this::toDto)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public ProductDto create(CreateProductDto dto) {
        validator.validate(dto);
        Product product = toEntity(dto);
        repository.save(product);

        return toDto(product);
    }

    private Product toEntity(CreateProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return product;
    }

    private ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        return dto;
    }

}

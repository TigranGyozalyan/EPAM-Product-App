package com.example.product.app.service.impl;

import com.example.product.app.domain.dto.in.CreateProductDto;
import com.example.product.app.domain.dto.out.ProductDto;
import com.example.product.app.domain.entity.Product;
import com.example.product.app.exception.NotFoundException;
import com.example.product.app.mapper.Mapper;
import com.example.product.app.repository.ProductRepository;
import com.example.product.app.service.ProductService;
import com.example.product.app.validation.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductValidator validator;
    private final Mapper mapper;

    @Override
    public ProductDto getById(Integer id) {
        return repository.findById(id)
            .map(mapper::toDto)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public ProductDto create(CreateProductDto dto) {
        validator.validate(dto);
        Product product = mapper.toEntity(dto);
        repository.save(product);

        return mapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll().stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

}

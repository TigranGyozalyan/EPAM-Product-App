package com.example.product.app.service;

import com.example.product.app.domain.dto.in.CreateProductDto;
import com.example.product.app.domain.dto.out.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getById(Integer id);

    ProductDto create(CreateProductDto dto);

    List<ProductDto> getAll();

}

package com.example.product.app.service;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.domain.dto.ProductDto;

public interface ProductService {

    ProductDto getById(Integer id);

    ProductDto create(CreateProductDto dto);

}

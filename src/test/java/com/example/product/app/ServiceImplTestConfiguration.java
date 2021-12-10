package com.example.product.app;

import com.example.product.app.repository.ProductRepository;
import com.example.product.app.service.ProductService;
import com.example.product.app.service.impl.ProductServiceImpl;
import org.mockito.Mock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ServiceImplTestConfiguration {

    @MockBean
    private ProductRepository repository;

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(repository);
    }

}

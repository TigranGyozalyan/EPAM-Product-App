package com.example.product.app.repository;

import com.example.product.app.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    List<Product> findAll();

}

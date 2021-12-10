package com.example.product.app.controller;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

}

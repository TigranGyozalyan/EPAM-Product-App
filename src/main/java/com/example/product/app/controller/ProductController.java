package com.example.product.app.controller;

import com.example.product.app.domain.dto.CreateProductDto;
import com.example.product.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> findProductById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

}

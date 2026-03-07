package com.fcolucasvieira.auth.controller;

import com.fcolucasvieira.auth.dto.product.ProductRequestDTO;
import com.fcolucasvieira.auth.dto.product.ProductResponseDTO;
import com.fcolucasvieira.auth.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> postProduct(@RequestBody @Valid ProductRequestDTO request){
        ProductResponseDTO response = this.productService.create(request);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(Pageable pageable){
        return ResponseEntity.ok(productService.getAll(pageable));
        }
}

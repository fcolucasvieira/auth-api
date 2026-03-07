package com.fcolucasvieira.auth.service;

import com.fcolucasvieira.auth.domain.product.Product;
import com.fcolucasvieira.auth.dto.product.ProductRequestDTO;
import com.fcolucasvieira.auth.dto.product.ProductResponseDTO;
import com.fcolucasvieira.auth.mapper.ProductMapper;
import com.fcolucasvieira.auth.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO create(ProductRequestDTO request){
        Product product = productMapper.toEntity(request);

        this.productRepository.save(product);

        return productMapper.toResponse(product);
    }

    public Page<ProductResponseDTO> getAll(Pageable pageable) {
        Page<Product> products = this.productRepository.findAll(pageable);

        return products.map(productMapper::toResponse);
    }
}

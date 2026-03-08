package com.fcolucasvieira.auth.mapper;

import com.fcolucasvieira.auth.domain.product.Product;
import com.fcolucasvieira.auth.dto.product.ProductRequestDTO;
import com.fcolucasvieira.auth.dto.product.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequestDTO dto);

    ProductResponseDTO toResponse(Product product);
}

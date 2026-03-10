package com.fcolucasvieira.auth.repository;

import com.fcolucasvieira.auth.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

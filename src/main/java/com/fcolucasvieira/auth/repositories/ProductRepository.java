package com.fcolucasvieira.auth.repositories;

import com.fcolucasvieira.auth.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

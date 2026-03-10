package com.fcolucasvieira.auth.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @Schema(example = "Arroz")
        @NotBlank(message = "Name cannot be empty")
        @Size(min = 2, max = 100, message = "Name must contain between 2 and 100 characters")
        String name,

        @Schema(example = "7.50")
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than zero")
        BigDecimal price
) {}

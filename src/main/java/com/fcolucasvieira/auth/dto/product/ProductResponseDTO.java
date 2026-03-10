package com.fcolucasvieira.auth.dto.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(UUID id,
                                 String name,
                                 BigDecimal price) {}

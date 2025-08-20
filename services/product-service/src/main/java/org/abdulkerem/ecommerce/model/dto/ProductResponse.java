package org.abdulkerem.ecommerce.model.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Long productId,
        String name,
        String description,
        Integer availableQuantity,
        BigDecimal price,
        Long categoryId
)
{
}

package org.abdulkerem.ecommerce.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Long productId,
        @NotNull(message = "Product name is required.")
        String name,
        @NotNull(message = "Product description is required.")
        String description,
        @Positive(message = "Quantity should be positive")
        Integer availableQuantity,
        @Positive(message = "Price should be positive")
        BigDecimal price,
        @NotNull(message = "Product category is required")
        Long categoryId
)
{
}

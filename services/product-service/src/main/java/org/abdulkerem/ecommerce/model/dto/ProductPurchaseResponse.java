package org.abdulkerem.ecommerce.model.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductPurchaseResponse(
    Long productId,
    String name,
    String description,
    BigDecimal price,
    Integer quantity
)
{
}

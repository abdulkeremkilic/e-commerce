package org.abdulkerem.ecommerce.model.dto;

import java.math.BigDecimal;

public record Product(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
)
{
}

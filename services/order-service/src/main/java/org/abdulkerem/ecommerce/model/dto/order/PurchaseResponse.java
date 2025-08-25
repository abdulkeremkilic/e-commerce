package org.abdulkerem.ecommerce.model.dto.order;

import java.math.BigDecimal;

public record PurchaseResponse(
     Long productId,
     String name,
     String description,
     BigDecimal price,
     Integer quantity
)
{
}

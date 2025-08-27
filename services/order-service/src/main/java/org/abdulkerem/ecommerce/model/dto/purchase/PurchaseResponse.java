package org.abdulkerem.ecommerce.model.dto.purchase;

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

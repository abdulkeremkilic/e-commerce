package org.abdulkerem.ecommerce.model.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
    @NotNull(message = "ProductId is mandatory")
    Long productId,
    @NotNull(message = "Quantity is mandatory")
    Integer quantity
)
{
}

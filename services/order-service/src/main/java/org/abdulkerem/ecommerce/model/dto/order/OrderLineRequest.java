package org.abdulkerem.ecommerce.model.dto.order;

import lombok.Builder;

@Builder
public record OrderLineRequest(
        Long orderLineId,
        Long customerOrderId,
        Long productId,
        Integer quantity
)
{
}

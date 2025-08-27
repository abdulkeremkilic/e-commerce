package org.abdulkerem.ecommerce.model.dto.order_line;

import lombok.Builder;

@Builder
public record OrderLineResponse(
        Long orderLineId,
        Integer quantity
)
{
}

package org.abdulkerem.ecommerce.model.dto.order;

import lombok.Builder;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;

@Builder
public record OrderResponse(
        Long customerOrderId,
        String reference,
        BigDecimal total,
        PaymentMethod paymentMethod,
        String customerId
)
{
}

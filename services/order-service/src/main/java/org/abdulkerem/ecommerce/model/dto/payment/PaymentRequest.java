package org.abdulkerem.ecommerce.model.dto.payment;

import lombok.Builder;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
        BigDecimal total,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        CustomerResponse customer
)
{
}

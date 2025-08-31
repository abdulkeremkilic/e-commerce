package org.abdulkerem.ecommerce.model.dto.payment;

import lombok.Builder;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerRequest;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
        Long paymentId,
        BigDecimal total,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        CustomerRequest customer
)
{
}

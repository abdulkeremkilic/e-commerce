package org.abdulkerem.ecommerce.model.dto.kafka;

import lombok.Builder;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;

@Builder
public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal total,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
)
{
}

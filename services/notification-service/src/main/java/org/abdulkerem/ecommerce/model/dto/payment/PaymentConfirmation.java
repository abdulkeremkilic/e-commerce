package org.abdulkerem.ecommerce.model.dto.payment;

import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal total,
        PaymentMethod paymentMethod,
        String firstName,
        String lastName,
        String email
)
{
}

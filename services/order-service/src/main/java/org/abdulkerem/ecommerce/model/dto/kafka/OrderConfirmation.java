package org.abdulkerem.ecommerce.model.dto.kafka;

import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.abdulkerem.ecommerce.model.dto.order.PurchaseResponse;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal total,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> productList
) {
}

package org.abdulkerem.ecommerce.model.dto.kafka;

import lombok.Builder;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseResponse;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
        String orderReference,
        BigDecimal total,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> productList
) {
}

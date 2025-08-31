package org.abdulkerem.ecommerce.model.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseRequest;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
    Long custOrdId,
    String orderReference,
    @Positive(message = "Amount should be positive.")
    BigDecimal total,
    @NotNull(message = "Payment method should be precised.")
    PaymentMethod paymentMethod,
    @NotNull(message = "Customer should be present.")
    @NotBlank(message = "Customer should be present.")
    String customerId,
    @NotEmpty(message = "You should at least purchase one product.")
    List<PurchaseRequest> productList
)
{
}

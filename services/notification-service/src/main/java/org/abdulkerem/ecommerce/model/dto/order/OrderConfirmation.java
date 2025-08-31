package org.abdulkerem.ecommerce.model.dto.order;

import org.abdulkerem.ecommerce.model.dto.Customer;
import org.abdulkerem.ecommerce.model.dto.Product;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
    String orderReference,
    BigDecimal total,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> productList
)
{
}

package org.abdulkerem.ecommerce.client.abstracts;

import org.abdulkerem.ecommerce.model.dto.payment.PaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPaymentClient {
    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequest paymentRequest);
}

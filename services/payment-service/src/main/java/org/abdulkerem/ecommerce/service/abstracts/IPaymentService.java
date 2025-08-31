package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.payment.PaymentRequest;

public interface IPaymentService {
    Long proceedPayment(PaymentRequest paymentRequest);
}

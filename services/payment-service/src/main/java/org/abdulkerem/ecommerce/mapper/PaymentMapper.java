package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.dto.payment.PaymentRequest;
import org.abdulkerem.ecommerce.model.entity.PaymentEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public PaymentEntity toPaymentEntity(PaymentRequest paymentRequest) {
        return PaymentEntity.builder()
                .pymntId(paymentRequest.paymentId())
                .paymentMethod(paymentRequest.paymentMethod())
                .orderId(paymentRequest.orderId())
                .total(paymentRequest.total())
                .build();
    }
}

package org.abdulkerem.ecommerce.service.concretes;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.mapper.PaymentMapper;
import org.abdulkerem.ecommerce.model.dto.kafka.PaymentNotificationRequest;
import org.abdulkerem.ecommerce.model.dto.payment.PaymentRequest;
import org.abdulkerem.ecommerce.model.entity.PaymentEntity;
import org.abdulkerem.ecommerce.producer.NotificationProducer;
import org.abdulkerem.ecommerce.repository.PaymentRepository;
import org.abdulkerem.ecommerce.service.abstracts.IPaymentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Long proceedPayment(PaymentRequest paymentRequest) {

        PaymentEntity paymentEntity = this.paymentRepository.save(this.paymentMapper.toPaymentEntity(paymentRequest));
        notificationProducer.sendNotification(
                PaymentNotificationRequest
                        .builder()
                        .orderReference(paymentRequest.orderReference())
                        .total(paymentRequest.total())
                        .paymentMethod(paymentRequest.paymentMethod())
                        .customerFirstName(paymentRequest.customer().firstName())
                        .customerLastName(paymentRequest.customer().lastName())
                        .customerEmail(paymentRequest.customer().email())

                .build());
        return paymentEntity.getPymntId();
    }
}

package org.abdulkerem.ecommerce.consumer;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.abdulkerem.ecommerce.model.dto.order.OrderConfirmation;
import org.abdulkerem.ecommerce.model.dto.payment.PaymentConfirmation;
import org.abdulkerem.ecommerce.model.entity.NotificationEntity;
import org.abdulkerem.ecommerce.model.enums.NotificationType;
import org.abdulkerem.ecommerce.repository.NotificationRepository;
import org.abdulkerem.ecommerce.service.abstracts.IEmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationListener {

    private final NotificationRepository notificationRepository;
    private final IEmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consuming Payment Confirmation from Payment Topic: {}", paymentConfirmation);
        notificationRepository.save(NotificationEntity.builder()
                .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                .cdate(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .build());

        // send mail
        String fullName = paymentConfirmation.firstName() + " " + paymentConfirmation.lastName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.email(),
                fullName,
                paymentConfirmation.total(),
                paymentConfirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming Payment Confirmation from order Topic: {}", orderConfirmation);
        notificationRepository.save(NotificationEntity.builder()
                .notificationType(NotificationType.ORDER_CONFIRMATION)
                .cdate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build());

        // send mail
        String fullName = orderConfirmation.customer().fistName() + " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                fullName,
                orderConfirmation.total(),
                orderConfirmation.orderReference(),
                orderConfirmation.productList()
        );

    }

}

package org.abdulkerem.ecommerce.model.entity;

import lombok.*;
import org.abdulkerem.ecommerce.model.dto.order.OrderConfirmation;
import org.abdulkerem.ecommerce.model.dto.payment.PaymentConfirmation;
import org.abdulkerem.ecommerce.model.enums.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class NotificationEntity {
    @Id
    private String notificationId;
    private NotificationType notificationType;
    private LocalDateTime cdate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}

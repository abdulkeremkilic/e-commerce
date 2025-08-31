package org.abdulkerem.ecommerce.service.abstracts;

import jakarta.mail.MessagingException;
import org.abdulkerem.ecommerce.model.dto.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IEmailService {
    void sendPaymentSuccessEmail(
            String to,
            String customerName,
            BigDecimal total,
            String orderReference) throws MessagingException;

    void sendOrderConfirmationEmail(
            String to,
            String customerName,
            BigDecimal total,
            String orderReference,
            List<Product> productList) throws MessagingException;

}

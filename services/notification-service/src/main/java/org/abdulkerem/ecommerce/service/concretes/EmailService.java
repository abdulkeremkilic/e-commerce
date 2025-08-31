package org.abdulkerem.ecommerce.service.concretes;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.abdulkerem.ecommerce.model.dto.Product;
import org.abdulkerem.ecommerce.model.enums.EmailTemplate;
import org.abdulkerem.ecommerce.service.abstracts.IEmailService;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String to,
            String customerName,
            BigDecimal total,
            String orderReference) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper =
                new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        final String templateName = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
        Map<String, Object> context = new HashMap<>();
        context.put("customerName", customerName);
        context.put("total", total);
        context.put("orderReference", orderReference);

        Context mailContext = new Context();
        mailContext.setVariables(context);

        messageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());
        messageHelper.setFrom("dummy_mail@tempmail.com");

        try {
            String htmlTemplate  = templateEngine.process(templateName, mailContext);
            messageHelper.setText(htmlTemplate, true);
            messageHelper.setTo(to);
            mailSender.send(mimeMessage);
            log.info(String.format("Email sent successfully to: %s", to));
        } catch (MessagingException e) {
            log.error(String.format("Email sent failed: %s", e.getMessage()));
        }
    }

    @Async
    public void sendOrderConfirmationEmail(
            String to,
            String customerName,
            BigDecimal total,
            String orderReference,
            List<Product> productList) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper =
                new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        final String templateName = EmailTemplate.ORDER_CONFIRMATION.getTemplate();
        Map<String, Object> context = new HashMap<>();
        context.put("customerName", customerName);
        context.put("total", total);
        context.put("orderReference", orderReference);
        context.put("productList", productList);

        Context mailContext = new Context();
        mailContext.setVariables(context);

        messageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());
        messageHelper.setFrom("dummy_mail@tempmail.com");

        try {
            String htmlTemplate  = templateEngine.process(templateName, mailContext);
            messageHelper.setText(htmlTemplate, true);
            messageHelper.setTo(to);
            mailSender.send(mimeMessage);
            log.info(String.format("Email sent successfully to: %s", to));
        } catch (MessagingException e) {
            log.error(String.format("Email sent failed: %s", e.getMessage()));
        }
    }

}

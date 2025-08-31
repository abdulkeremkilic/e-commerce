package org.abdulkerem.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.model.dto.payment.PaymentRequest;
import org.abdulkerem.ecommerce.service.abstracts.IPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final IPaymentService paymentService;

    public ResponseEntity<Long> proceedPayment(@RequestBody @Valid PaymentRequest request) {
        return ResponseEntity.ok(this.paymentService.proceedPayment(request));
    }
}

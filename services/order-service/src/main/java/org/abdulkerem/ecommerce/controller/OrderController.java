package org.abdulkerem.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;
import org.abdulkerem.ecommerce.model.dto.order.OrderResponse;
import org.abdulkerem.ecommerce.service.abstracts.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody @Valid OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("order-id") Long orderId) {
        return ResponseEntity.ok(orderService.inquireOrder(orderId));
    }
}

package org.abdulkerem.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineResponse;
import org.abdulkerem.ecommerce.service.abstracts.IOrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-line")
@RequiredArgsConstructor
public class OrderLineController {

    private final IOrderLineService orderLineService;

    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderLineResponse>> getOrderLines(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(this.orderLineService.inquireOrderLinesByOrderId(orderId));
    }
}

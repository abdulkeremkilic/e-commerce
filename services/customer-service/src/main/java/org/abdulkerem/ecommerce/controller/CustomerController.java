package org.abdulkerem.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.model.dto.CustomerRequest;
import org.abdulkerem.ecommerce.model.dto.CustomerResponse;
import org.abdulkerem.ecommerce.service.abstracts.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody @Validated CustomerRequest request) {
        return ResponseEntity.ok(this.customerService.createCustomer(request));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Validated CustomerRequest request) {
        this.customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerResponse>> findAllCustomers() {
        return ResponseEntity.ok(customerService.inquireAllCustomers());
    }

}

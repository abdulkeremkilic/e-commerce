package org.abdulkerem.ecommerce.client.abstracts;

import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface ICustomerClient {
    @GetMapping("/{customerId}")
    Optional<CustomerResponse> inquireCustomerByCustomerId(@PathVariable("customerId") String customerId);
}

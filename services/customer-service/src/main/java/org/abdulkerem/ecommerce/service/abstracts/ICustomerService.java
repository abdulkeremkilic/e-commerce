package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.customer.CustomerRequest;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    String createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest request);

    List<CustomerResponse> inquireAllCustomers();

    CustomerResponse inquireCustomerByCustomerId(String customerId);
}

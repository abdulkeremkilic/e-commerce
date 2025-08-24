package org.abdulkerem.ecommerce.service.concretes;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.exceptions.CustomerNotFoundException;
import org.abdulkerem.ecommerce.mapper.CustomerMapper;
import org.abdulkerem.ecommerce.model.entity.CustomerEntity;
import org.abdulkerem.ecommerce.model.dto.CustomerRequest;
import org.abdulkerem.ecommerce.model.dto.CustomerResponse;
import org.abdulkerem.ecommerce.repository.CustomerRepository;
import org.abdulkerem.ecommerce.service.abstracts.ICustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerRequest customerRequest) {
        //Todo: Null value should not be saved!
        CustomerEntity customerEntity = customerRepository.save(customerMapper.requestToCustomerEntity(customerRequest));
        return customerEntity.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        CustomerEntity customerEntity = this.customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer not found %s", request.id())));
        this.updateCustomer(request, customerEntity);
        this.customerRepository.save(customerEntity);
    }

    @Override
    public List<CustomerResponse> inquireAllCustomers() {
        return this.customerRepository.findAll()
                .stream()
                .map(customerMapper::customerEntityToCustomerResponse)
                .toList();
    }

    @Override
    public CustomerResponse inquireCustomerByCustomerId(String customerId) {
        return this.customerRepository.findById(customerId)
                .map(customerMapper::customerEntityToCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer not found %s", customerId)));
    }

    private void updateCustomer(CustomerRequest customerRequest, CustomerEntity customerEntity) {
        if(StringUtils.isNotBlank(customerRequest.firstName()))
            customerEntity.setFirstName(customerRequest.firstName());
        if (StringUtils.isNotBlank(customerRequest.lastName()))
            customerEntity.setLastName(customerRequest.lastName());
        if(StringUtils.isNotBlank(customerRequest.email()))
            customerEntity.setEmail(customerRequest.email());
        if(Objects.nonNull(customerRequest.address()))
            customerEntity.setAddress(customerRequest.address());
    }
}

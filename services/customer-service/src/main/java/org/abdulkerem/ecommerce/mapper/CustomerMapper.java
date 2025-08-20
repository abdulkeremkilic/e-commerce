package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.entity.CustomerEntity;
import org.abdulkerem.ecommerce.model.dto.CustomerRequest;
import org.abdulkerem.ecommerce.model.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerMapper {
    public CustomerEntity requestToCustomerEntity(CustomerRequest customerRequest) {
        if (Objects.isNull(customerRequest))
            return null;


        return CustomerEntity.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }

    public CustomerResponse customerEntityToCustomerResponse(CustomerEntity customerEntity) {
        return new CustomerResponse(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getEmail(),
                customerEntity.getAddress()
        );
    }
}

package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;
import org.abdulkerem.ecommerce.model.entity.CustomerOrderEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderMapper {
    public CustomerOrderEntity toCustomerOrderEntity(OrderRequest orderRequest) {
        return CustomerOrderEntity.builder()
                .customerId(orderRequest.customerId())
                .reference(orderRequest.reference())
                .total(orderRequest.total())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }
}

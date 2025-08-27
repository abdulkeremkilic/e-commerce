package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;
import org.abdulkerem.ecommerce.model.dto.order.OrderResponse;
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

    public OrderResponse toCustomerOrderResponse(CustomerOrderEntity customerOrderEntity) {
        return OrderResponse.builder()
                .customerOrderId(customerOrderEntity.getCustomerOrderId())
                .reference(customerOrderEntity.getReference())
                .total(customerOrderEntity.getTotal())
                .paymentMethod(customerOrderEntity.getPaymentMethod())
                .customerId(customerOrderEntity.getCustomerId())
                .build();
    }
}

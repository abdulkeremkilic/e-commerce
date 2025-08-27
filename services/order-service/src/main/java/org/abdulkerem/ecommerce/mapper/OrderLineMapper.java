package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineRequest;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineResponse;
import org.abdulkerem.ecommerce.model.entity.CustomerOrderEntity;
import org.abdulkerem.ecommerce.model.entity.OrderLineEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLineEntity toOrderLineEntity(OrderLineRequest orderLineRequest) {
        return OrderLineEntity.builder()
                .orderLineId(orderLineRequest.orderLineId())
                .quantity(orderLineRequest.quantity())
                .customerOrderEntity(
                        CustomerOrderEntity.builder()
                                .customerOrderId(orderLineRequest.customerOrderId())
                                .build()
                )
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLineEntity orderLineEntity) {
        return OrderLineResponse.builder()
                .orderLineId(orderLineEntity.getOrderLineId())
                .quantity(orderLineEntity.getQuantity())
                .build();
    }
}

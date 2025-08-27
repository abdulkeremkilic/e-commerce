package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;
import org.abdulkerem.ecommerce.model.dto.order.OrderResponse;

public interface IOrderService {
    Long createOrder(OrderRequest request);
    OrderResponse inquireOrder(Long orderId);
}

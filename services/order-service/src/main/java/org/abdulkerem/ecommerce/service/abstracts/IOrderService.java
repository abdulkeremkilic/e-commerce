package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;

public interface IOrderService {
    Long createOrder(OrderRequest request);
}

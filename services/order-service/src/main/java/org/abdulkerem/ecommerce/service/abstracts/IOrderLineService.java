package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineRequest;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineResponse;

import java.util.List;

public interface IOrderLineService {
    Long persistOrderLine(OrderLineRequest request);

    List<OrderLineResponse> inquireOrderLinesByOrderId(Long orderId);
}

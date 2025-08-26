package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.order.OrderLineRequest;

public interface IOrderLineService {
    Long persistOrderLine(OrderLineRequest request);
}

package org.abdulkerem.ecommerce.service.concretes;

import lombok.AllArgsConstructor;
import org.abdulkerem.ecommerce.mapper.OrderLineMapper;
import org.abdulkerem.ecommerce.model.dto.order.OrderLineRequest;
import org.abdulkerem.ecommerce.model.entity.OrderLineEntity;
import org.abdulkerem.ecommerce.repository.OrderLineRepository;
import org.abdulkerem.ecommerce.service.abstracts.IOrderLineService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl implements IOrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public Long persistOrderLine(OrderLineRequest request) {
        OrderLineEntity orderLineEntity = orderLineMapper.toOrderLineEntity(request);
        return orderLineRepository.save(orderLineEntity).getOrderLineId();
    }
}

package org.abdulkerem.ecommerce.service.concretes;

import lombok.AllArgsConstructor;
import org.abdulkerem.ecommerce.mapper.OrderLineMapper;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineRequest;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineResponse;
import org.abdulkerem.ecommerce.model.entity.OrderLineEntity;
import org.abdulkerem.ecommerce.repository.OrderLineRepository;
import org.abdulkerem.ecommerce.service.abstracts.IOrderLineService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<OrderLineResponse> inquireOrderLinesByOrderId(Long orderId) {
        return this.orderLineRepository.findByCustomerOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .toList();
    }
}

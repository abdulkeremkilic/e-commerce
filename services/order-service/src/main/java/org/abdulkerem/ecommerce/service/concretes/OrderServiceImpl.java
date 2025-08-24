package org.abdulkerem.ecommerce.service.concretes;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.client.ICustomerClient;
import org.abdulkerem.ecommerce.exceptions.BusinessValidationException;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.abdulkerem.ecommerce.model.dto.order.OrderRequest;
import org.abdulkerem.ecommerce.service.abstracts.IOrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ICustomerClient customerClient;

    @Override
    public Long createOrder(OrderRequest request) {
        //Checking the customer by OpenFeign
        CustomerResponse customer = this.customerClient.inquireCustomerByCustomerId(request.customerId())
                .orElseThrow(() -> new BusinessValidationException(request.customerId()));

        //purchase the product --> product ms

        //persist order

        //persist order lines

        //start payment process

        //send the order confirmation --> notification ms
        return null;
    }
}

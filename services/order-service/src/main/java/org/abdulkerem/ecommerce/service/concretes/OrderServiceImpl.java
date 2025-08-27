package org.abdulkerem.ecommerce.service.concretes;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.client.abstracts.ICustomerClient;
import org.abdulkerem.ecommerce.client.abstracts.IProductClient;
import org.abdulkerem.ecommerce.kafka.OrderProducer;
import org.abdulkerem.ecommerce.mapper.CustomerOrderMapper;
import org.abdulkerem.ecommerce.model.dto.customer.CustomerResponse;
import org.abdulkerem.ecommerce.model.dto.kafka.OrderConfirmation;
import org.abdulkerem.ecommerce.model.dto.order.*;
import org.abdulkerem.ecommerce.model.dto.order_line.OrderLineRequest;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseResponse;
import org.abdulkerem.ecommerce.model.entity.CustomerOrderEntity;
import org.abdulkerem.ecommerce.repository.OrderRepository;
import org.abdulkerem.ecommerce.service.abstracts.IOrderLineService;
import org.abdulkerem.ecommerce.service.abstracts.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ICustomerClient customerClient;
    private final IProductClient productClient;
    private final OrderProducer orderProducer;
    private final OrderRepository orderRepository;
    private final CustomerOrderMapper customerOrderMapper;
    private final IOrderLineService orderLineService;

    @Override
    public Long createOrder(OrderRequest request) {
        //Checking the customer from customer-service by using OpenFeign
        CustomerResponse customer = this.customerClient.inquireCustomerByCustomerId(request.customerId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer with provided id not found %s", request.customerId())));

        //Purchasing the products with product-service by using Rest Template
        List<PurchaseResponse> purchasedProductList = this.productClient.purchaseProduct(request.productList());

        //persist order
        CustomerOrderEntity customerOrderEntity = this.orderRepository.save(this.customerOrderMapper.toCustomerOrderEntity(request));

        //persist order lines
        for (PurchaseRequest purchaseRequest : request.productList()) {
            orderLineService.persistOrderLine(
                    OrderLineRequest.builder()
                            .customerOrderId(customerOrderEntity.getCustomerOrderId())
                            .productId(purchaseRequest.productId())
                            .quantity(purchaseRequest.quantity())
                            .build()
            );
        }

        //start payment process

        //send the order confirmation --> notification ms
        orderProducer.sendOrderConfirmation(
                OrderConfirmation.builder()
                        .orderReference(request.reference())
                        .total(request.total())
                        .customerResponse(customer)
                        .productList(purchasedProductList)
                        .build()
        );

        return customerOrderEntity.getCustomerOrderId();
    }

    @Override
    public OrderResponse inquireOrder(Long orderId) {
        return this.orderRepository.findById(orderId)
                .map(this.customerOrderMapper::toCustomerOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order with provided id not found: %s", orderId)));
    }
}

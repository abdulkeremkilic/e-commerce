package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Long> {

    @Query(value = """
    select o from order_line o
    where o.cust_ord_id = :customerOrderId
    """, nativeQuery = true)
    List<OrderLineEntity> findByCustomerOrderId(Long customerOrderId);
}

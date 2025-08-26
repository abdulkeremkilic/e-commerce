package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Long> {
}

package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
}

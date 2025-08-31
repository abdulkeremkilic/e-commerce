package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}

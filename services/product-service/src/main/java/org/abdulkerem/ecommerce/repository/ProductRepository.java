package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByProductIdInOrderByProductId(List<Long> productIdList);
}

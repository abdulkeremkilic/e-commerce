package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
}

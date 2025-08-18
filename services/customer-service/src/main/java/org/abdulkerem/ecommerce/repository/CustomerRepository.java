package org.abdulkerem.ecommerce.repository;

import org.abdulkerem.ecommerce.model.customer.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}

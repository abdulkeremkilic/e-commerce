package org.abdulkerem.ecommerce.model.dto;

public record Customer(
        String customerId,
        String fistName,
        String lastName,
        String email
)
{
}

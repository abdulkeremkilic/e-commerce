package org.abdulkerem.ecommerce.model.dto.customer;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
)
{
}

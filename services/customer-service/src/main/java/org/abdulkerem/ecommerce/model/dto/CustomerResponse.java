package org.abdulkerem.ecommerce.model.dto;

import org.abdulkerem.ecommerce.model.entity.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
)
{
}

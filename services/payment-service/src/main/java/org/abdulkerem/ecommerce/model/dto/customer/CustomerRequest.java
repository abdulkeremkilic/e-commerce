package org.abdulkerem.ecommerce.model.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CustomerRequest(
        String customerId,
        @NotNull(message = "First name is required.")
        String firstName,
        @NotNull(message = "Last name is required.")
        String lastName,
        @NotNull(message = "Email is required.")
        @Email(message = "Mail address is not valid.")
        String email
)
{
}

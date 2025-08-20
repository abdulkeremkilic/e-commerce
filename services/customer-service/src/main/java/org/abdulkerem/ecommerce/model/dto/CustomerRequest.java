package org.abdulkerem.ecommerce.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.abdulkerem.ecommerce.model.entity.Address;

public record CustomerRequest(
        String id,
        @NotNull(message = "Firstname is required.")
        String firstName,
        @NotNull(message = "Lastname is required.")
        String lastName,
        @NotNull(message = "Email is required.")
        @Email
        String email,
        Address address)
{
}

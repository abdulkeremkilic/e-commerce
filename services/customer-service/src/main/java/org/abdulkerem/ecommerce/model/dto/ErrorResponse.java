package org.abdulkerem.ecommerce.model.dto;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
)
{
}

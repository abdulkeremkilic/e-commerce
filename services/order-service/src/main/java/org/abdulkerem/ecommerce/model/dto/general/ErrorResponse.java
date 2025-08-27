package org.abdulkerem.ecommerce.model.dto.general;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
)
{
}
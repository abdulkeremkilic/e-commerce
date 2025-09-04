package org.abdulkerem.ecommerce.model.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.config")
public record ApplicationConfig
        (
        String productServiceUrl,
        String paymentServiceUrl,
        String customerServiceUrl
        )
{
}

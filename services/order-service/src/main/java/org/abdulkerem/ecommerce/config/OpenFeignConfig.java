package org.abdulkerem.ecommerce.config;

import feign.Feign;
import org.abdulkerem.ecommerce.client.abstracts.ICustomerClient;
import org.abdulkerem.ecommerce.client.abstracts.IPaymentClient;
import org.abdulkerem.ecommerce.model.dto.ApplicationConfig;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {

    @Bean
    public ICustomerClient customerClient(ApplicationConfig applicationConfig) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .target(ICustomerClient.class, applicationConfig.customerServiceUrl());
    }

    @Bean
    public IPaymentClient paymentClient(ApplicationConfig applicationConfig) {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .target(IPaymentClient.class, applicationConfig.paymentServiceUrl());
    }


}

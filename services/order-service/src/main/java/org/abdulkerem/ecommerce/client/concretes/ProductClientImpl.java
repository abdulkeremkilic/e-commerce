package org.abdulkerem.ecommerce.client.concretes;

import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.client.abstracts.IProductClient;
import org.abdulkerem.ecommerce.exceptions.BusinessValidationException;
import org.abdulkerem.ecommerce.model.dto.ApplicationConfig;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClientImpl implements IProductClient {

    private final ApplicationConfig applicationConfig;
    private final RestTemplate restTemplate; //TODO: Change Rest Template with WebClient

    @Override
    public List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(request, headers);

        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<List<PurchaseResponse>>() {};

        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                applicationConfig.productServiceUrl() + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
                );

        if(responseEntity.getStatusCode().isError())
            throw new BusinessValidationException("Error while processing purchase request: " + responseEntity.getStatusCode());

        return responseEntity.getBody();
    }
}

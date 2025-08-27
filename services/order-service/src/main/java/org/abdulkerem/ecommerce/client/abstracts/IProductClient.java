package org.abdulkerem.ecommerce.client.abstracts;

import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.purchase.PurchaseResponse;

import java.util.List;

public interface IProductClient {
    List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> request);
}

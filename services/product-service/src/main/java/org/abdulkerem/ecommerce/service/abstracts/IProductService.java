package org.abdulkerem.ecommerce.service.abstracts;

import org.abdulkerem.ecommerce.model.dto.ProductPurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.ProductPurchaseResponse;
import org.abdulkerem.ecommerce.model.dto.ProductRequest;
import org.abdulkerem.ecommerce.model.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    Long createProduct(ProductRequest request);
    ProductResponse getProductById(Long productId);
    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
}

package org.abdulkerem.ecommerce.mapper;

import org.abdulkerem.ecommerce.model.dto.ProductPurchaseResponse;
import org.abdulkerem.ecommerce.model.dto.ProductRequest;
import org.abdulkerem.ecommerce.model.dto.ProductResponse;
import org.abdulkerem.ecommerce.model.entity.CategoryEntity;
import org.abdulkerem.ecommerce.model.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductEntity productRequestToProductEntity(ProductRequest productRequest) {
        return ProductEntity.builder()
                .productId(productRequest.productId())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .category(CategoryEntity.builder()
                        .categoryId(productRequest.categoryId())
                        .build())
                .build();
    }

    public ProductResponse productEntityToProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .productId(productEntity.getProductId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .availableQuantity(productEntity.getAvailableQuantity())
                .categoryId(productEntity.getCategory().getCategoryId())
                .build();
    }

    public ProductPurchaseResponse productEntityToProductPurchaseResponse(ProductEntity productEntity, Integer quantity) {
        return ProductPurchaseResponse.builder()
                .productId(productEntity.getProductId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(quantity)
                .build();
    }
}

package org.abdulkerem.ecommerce.service.concretes;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.exceptions.ProductPurchaseException;
import org.abdulkerem.ecommerce.mapper.ProductMapper;
import org.abdulkerem.ecommerce.model.dto.ProductPurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.ProductPurchaseResponse;
import org.abdulkerem.ecommerce.model.dto.ProductRequest;
import org.abdulkerem.ecommerce.model.dto.ProductResponse;
import org.abdulkerem.ecommerce.model.entity.ProductEntity;
import org.abdulkerem.ecommerce.repository.ProductRepository;
import org.abdulkerem.ecommerce.service.abstracts.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Long createProduct(ProductRequest request) {
        ProductEntity productEntity = this.productMapper.toProductEntity(request);
       return productRepository.save(productEntity).getProductId();
    }

    public ProductResponse getProductById(Long productId) {
        return this.productRepository.findById(productId)
                .map(this.productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found with the id: %s", productId)));
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        List<Long> purchasedProductIdList = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        List<ProductEntity> storedProductEntityList = this.productRepository.findAllByProductIdInOrderByProductId(purchasedProductIdList);

        if(storedProductEntityList.size() != request.size())
            throw new ProductPurchaseException("One or more products does not exists");

        List<ProductPurchaseRequest> storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        ArrayList<ProductPurchaseResponse> purchasedProductList = new ArrayList<>();

        for (int i = 0; i < storedProductEntityList.size(); i++) {
            ProductEntity productEntity = storedProductEntityList.get(i);
            ProductPurchaseRequest productPurchaseRequest = storedRequest.get(i);
            if(productEntity.getAvailableQuantity() < productPurchaseRequest.quantity())
                throw new ProductPurchaseException("Insufficient quantity for the product with ID: " + productEntity.getProductId());


            Integer newAvailableQuantity = productEntity.getAvailableQuantity() - productPurchaseRequest.quantity();
            productEntity.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(productEntity);

            purchasedProductList.add(this.productMapper.toProductPurchaseResponse(productEntity, productPurchaseRequest.quantity()));
        }

        return purchasedProductList;

    }
}

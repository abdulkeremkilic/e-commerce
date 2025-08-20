package org.abdulkerem.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.abdulkerem.ecommerce.model.dto.ProductPurchaseRequest;
import org.abdulkerem.ecommerce.model.dto.ProductPurchaseResponse;
import org.abdulkerem.ecommerce.model.dto.ProductRequest;
import org.abdulkerem.ecommerce.model.dto.ProductResponse;
import org.abdulkerem.ecommerce.service.abstracts.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    //TODO: This is just a framework. All the models and logic will be updated.
    private final IProductService productService;

    @PostMapping(value = "/createProduct")
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping(value = "/getProduct")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody @Valid List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(this.productService.purchaseProducts(request));
    }
}

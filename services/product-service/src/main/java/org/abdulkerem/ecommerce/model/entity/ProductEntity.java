package org.abdulkerem.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long productId;
    private String name;
    private String description;
    private Integer availableQuantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}

package org.abdulkerem.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue
    private Long categoryId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<ProductEntity> products;
}

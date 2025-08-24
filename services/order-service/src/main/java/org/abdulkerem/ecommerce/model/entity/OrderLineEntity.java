package org.abdulkerem.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLineEntity {

    @Id
    @GeneratedValue
    private Long orderLineId;
    @ManyToOne
    @JoinColumn(name = "cust_ord_id") // Even if we don't want to write that Hibernate aligns with the primary key by default.
    private CustomerOrderEntity customerOrderEntity;
    private Long productId;
    private Integer quantity;
}

package org.abdulkerem.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cust_ord")
public class CustomerOrderEntity {
    @Id
    @GeneratedValue
    private Long customerOrderId;
    private String reference;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String customerId;
    @OneToMany(mappedBy = "customerOrder")
    private List<OrderLineEntity> orderLineList;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime cdate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime udate;
}

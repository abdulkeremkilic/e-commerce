package org.abdulkerem.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.abdulkerem.ecommerce.model.enums.PaymentMethod;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pymnt")
public class PaymentEntity {
    @Id
    @GeneratedValue
    private Long pymntId;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Long orderId;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime cdate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime udate;

}

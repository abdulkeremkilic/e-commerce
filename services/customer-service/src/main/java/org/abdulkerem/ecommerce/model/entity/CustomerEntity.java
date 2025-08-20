package org.abdulkerem.ecommerce.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
@Validated
public class CustomerEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}

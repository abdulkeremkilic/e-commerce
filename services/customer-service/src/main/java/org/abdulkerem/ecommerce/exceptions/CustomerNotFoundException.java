package org.abdulkerem.ecommerce.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String msg;
}

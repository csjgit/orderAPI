package com.cs.orderitem.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@EqualsAndHashCode
public class OrderItem {
    private String productCode;
    private String productName;
    private   int quantity;


}

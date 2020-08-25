package com.cs.order.api;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@Embeddable
public class  Address {
    private int pinCode;
    private String state;

}

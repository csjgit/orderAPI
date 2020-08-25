package com.cs.order.api;

import com.cs.orderitem.api.OrderItem;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Data
public class Order {


    private String customerName;
    private LocalDate orderDate;
    private Address  address;
    private List<OrderItem> orderItem;
    private double total;


}

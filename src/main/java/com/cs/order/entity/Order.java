package com.cs.order.entity;

import com.cs.order.api.Address;
import com.cs.orderitem.api.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="OrderData")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull(message = "customer Name is mandatory")
    private String customerName;
    @NotNull(message = "OrderDate is mandatory")
    private Date orderDate;
    @NotNull(message = "Address code is mandatory")
    @Embedded
    private Address address;
    @NotNull(message = "Total can not be null")
    private Double total;

}

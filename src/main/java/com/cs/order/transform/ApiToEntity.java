package com.cs.order.transform;

import com.cs.order.entity.Order;

import java.sql.Date;

public class ApiToEntity {
    private ApiToEntity() {

    }

    public static Order converToEntity(com.cs.order.api.Order orderItem) {

        com.cs.order.entity.Order orderEnity = new com.cs.order.entity.Order();
        orderEnity.setCustomerName(orderItem.getCustomerName());
        orderEnity.setAddress(orderItem.getAddress());
        orderEnity.setOrderDate(Date.valueOf(orderItem.getOrderDate()));
        return orderEnity;
    }
}

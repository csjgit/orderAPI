package com.cs.order.transform;

import com.cs.order.entity.Order;

import java.sql.Date;

public class Transformer {
    private Transformer() {

    }

    public static Order converToEntity(com.cs.order.api.Order orderItem) {

        com.cs.order.entity.Order orderEnity = new com.cs.order.entity.Order();
        orderEnity.setCustomerName(orderItem.getCustomerName());
        orderEnity.setAddress(orderItem.getAddress());
        orderEnity.setOrderDate(Date.valueOf(orderItem.getOrderDate()));
        orderEnity.setTotal(orderItem.getTotal());
        return orderEnity;
    }
    public static com.cs.order.api.Order converToAPI(Order oi)
    {
        com.cs.order.api.Order apiOrder = new com.cs.order.api.Order();
        apiOrder.setOrderDate(oi.getOrderDate().toLocalDate());
        apiOrder.setCustomerName(oi.getCustomerName());
        apiOrder.setAddress(oi.getAddress());
        apiOrder.setTotal(oi.getTotal());
        return  apiOrder;
    }
}

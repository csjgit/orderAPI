package com.cs.order.service;

import com.cs.order.api.Order;
import com.cs.order.exception.OrderNotFoundException;

import java.util.Optional;

public interface IOrderService
{
   long createOrder(Order orderItem);
   Order getOrder(Long orderId) throws OrderNotFoundException;

}

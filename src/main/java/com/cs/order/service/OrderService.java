package com.cs.order.service;

import com.cs.order.api.Order;
import com.cs.order.client.OrderItemClient;
import com.cs.order.dao.IOrderRepository;
import com.cs.order.dao.OrderDao;
import com.cs.order.exception.OrderNotFoundException;
import com.cs.order.transform.ApiToEntity;
import com.cs.orderitem.api.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository dao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemClient orderItemClient;
    @Override
    public long createOrder(Order order) {
        if (Objects.isNull(order))
            throw new IllegalArgumentException("Order can not be null");
        List<Long> orderItemIds =orderItemClient.createOrderItems(order.getOrderItem()).getBody();
        com.cs.order.entity.Order entity = ApiToEntity.converToEntity(order);
        com.cs.order.entity.Order saved =dao.save(entity);
        orderDao.saveOrderIdToOrderItems(saved.getId(),orderItemIds);


        return entity.getId();
    }

    @Override
    public com.cs.order.api.Order getOrder(Long orderId) throws OrderNotFoundException {
        Optional<com.cs.order.entity.Order>orderItem = dao.findById(orderId);
        com.cs.order.entity.Order oi =  orderItem.orElseThrow(()->  new OrderNotFoundException());
        com.cs.order.api.Order apiOrder = new Order();
        apiOrder.setOrderDate(oi.getOrderDate().toLocalDate());
        apiOrder.setCustomerName(oi.getCustomerName());
        apiOrder.setAddress(oi.getAddress());
        List<Long>orderIds= orderDao.getOrderItemsById(orderId);
        List<OrderItem>orderItems = orderItemClient.getOrderItems(orderIds).getBody();
        apiOrder.setOrderItem(orderItems);
        return apiOrder;

    }

}

package com.cs.order.controller;

import com.cs.order.api.Order;
import com.cs.order.exception.OrderNotFoundException;
import com.cs.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RestController
public class OrderController {
    @Autowired
    private IOrderService orderItemService;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody @Valid  Order orderItem) {

        long orderId = orderItemService.createOrder(orderItem);
        if (Objects.isNull(orderId))
            return new ResponseEntity<>("Order could not be placed", HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>("" + orderId, HttpStatus.CREATED);

    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") @NonNull Long orderId)
            throws OrderNotFoundException {

        Order orderItem = orderItemService.getOrder(orderId);

        return new ResponseEntity<>(orderItem, HttpStatus.OK);

    }


}

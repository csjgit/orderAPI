package com.cs.order.client;

import com.cs.orderitem.api.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@FeignClient(name="OderItemService",url="http://localhost:8081")
public interface OrderItemClient {
    @PostMapping("/createOrderItems")
    ResponseEntity<List<Long>> createOrderItems(@RequestBody @Valid List<OrderItem> orderItems);
    @PostMapping("/getOrderItems")
    public ResponseEntity<List<OrderItem>> getOrderItems(@RequestBody @NonNull List<Long> orderIds);

}

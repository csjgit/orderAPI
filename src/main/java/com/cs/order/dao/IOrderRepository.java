package com.cs.order.dao;

import com.cs.order.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<Order,Long> {


}

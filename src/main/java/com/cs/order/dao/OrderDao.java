package com.cs.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDao
{
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void saveOrderIdToOrderItems(Long orderId, List<Long> orderItemIds)
    {
       final String sql ="INSERT INTO OrderIdOrderItems (OrderId,OrderItemId) values (?,?)";
       orderItemIds.stream().forEach(i->jdbcTemplateObject.update(sql,orderId,i));
    }

    public List<Long> getOrderItemsById(Long orderId)
    {
        final String sql ="SELECT OrderItemId from OrderIdOrderItems where OrderId=?";
      return  jdbcTemplateObject.queryForList(sql,new Object[]{orderId},Long.class);
    }
}

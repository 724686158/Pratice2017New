package com.tcat.dao;

import com.tcat.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lzw on 2017/7/18.
 */
@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbc;
    public Order findOrder(long order_id) {
        List<Order> query = jdbc.query("SELECT * FROM order WHERE order_id = ?",
                new OrderRowMapper(), order_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<Order> allOrder()
    {
        List<Order> query=jdbc.query("SELECT * FROM order",new OrderRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addOrder( long order_id,
             Date createTime,
             String order_state,
             String order_delivery,
             long user_id,
             long good_id,
             int number1,
             double cost) {
        jdbc.update("INSERT INTO order(order_id,order_createtime,order_state,order_delivery,user_id, good_id, number,cost) VALUE (?, ?, ?, ?, ?, ?, ?, ?)",
                order_id,createTime,order_state,order_delivery,user_id,good_id,number1,cost);
    }

    public void modifyOrder(long order_id,
                            Date createTime,
                            String order_state,
                            String order_delivery,
                            int number,
                            double cost
                          ) {
        jdbc.update("UPDATE order SET order_createtime = ? AND order_state = ? AND order_delivery = ? And number = ? AND cost =  ? WHERE order_id = ?",
               createTime,order_state,order_delivery,number,cost,order_id);
    }

    public void deleteOrder(long order_id) {
        jdbc.update("DELETE from order  WHERE order_id = ?",
                order_id);
    }

    public class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrder_id(rs.getLong("order_id"));
            order.setGood_id(rs.getLong("good_id"));
            order.setCost(rs.getDouble("cost"));
            order.setOrder_createtime(rs.getDate("order_createtime"));
            order.setNumber(rs.getInt("number"));
            order.setOrder_delivery(rs.getString("order_delivery"));
            order.setUser_id(rs.getLong("user_id"));
            order.setOrder_state(rs.getString("order_state"));
            return order;
        }
    }
}

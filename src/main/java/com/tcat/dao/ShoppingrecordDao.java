package com.tcat.dao;

import com.tcat.model.Shoppingrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lzw on 2017/7/18.
 */
public class ShoppingrecordDao {
    @Autowired
    private JdbcTemplate jdbc;
    public Shoppingrecord findShoppingrecord(long shoppingrecord_id) {
        List<Shoppingrecord> query = jdbc.query("SELECT * FROM shoppingrecord WHERE shoppingrecord_id = ?",
                new ShoppingrecordRowMapper(), shoppingrecord_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<Shoppingrecord> allShoppingrecord()
    {
        List<Shoppingrecord> query=jdbc.query("SELECT * FROM  shoppingrecord",new ShoppingrecordRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addShoppingrecord(long shoppingrecord_id,
                                  long user_id,
                                  int number,
                                  Date recordtime) {
        jdbc.update("INSERT INTO shoppingrecord(shoppingrecord_id,user_id,number,recordtime) VALUE (?, ?, ?, ?)",
                shoppingrecord_id,user_id,number,recordtime);
    }

    public void modifyShoppuingrecord(long shoppingrecord_id,
                                      int number,
                                      Date recordtime) {
        jdbc.update("UPDATE shoppingrecord SET  number = ? AND recordtime = ?  WHERE shoppingrecord_id = ?",
                number,recordtime,shoppingrecord_id);
    }

    public void deleteShoppingrecord(long shoppingrecord_id) {
        jdbc.update("DELETE from shoppingrecord  WHERE .shoppingrecord_id = ?",
               shoppingrecord_id);
    }

    public class ShoppingrecordRowMapper implements RowMapper<Shoppingrecord> {
        @Override
        public Shoppingrecord mapRow(ResultSet rs, int rowNum) throws SQLException {
           Shoppingrecord shop = new Shoppingrecord();
           shop.setNumber(rs.getInt("number"));
           shop.setRecord_time(rs.getDate("record_time"));
           shop.setShoppingcart_id(rs.getLong("shoppingcart_id"));
           shop.setUser_id(rs.getLong("user_id"));
            return shop;
        }
    }

}

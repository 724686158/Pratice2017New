package com.tcat.dao;

import com.tcat.model.Shoppingrecord;
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
public class ShoppingrecordDao {
    @Autowired
    private JdbcTemplate jdbc;
    public Shoppingrecord findShoppingrecord(long shoppingcart_id, long good_id) {
        List<Shoppingrecord> query = jdbc.query("SELECT * FROM shoppingrecord WHERE shoppingcart_id = ? AND good_id = ?",
                new ShoppingrecordRowMapper(), shoppingcart_id, good_id);
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
                                  long good_id,
                                  int number,
                                  Date recordtime) {
        jdbc.update("INSERT INTO shoppingrecord(shoppingcart_id,good_id, number,record_time) VALUE (?, ?, ?, ?)",
                shoppingrecord_id,good_id,number,recordtime);
    }

    public void modifyShoppuingrecord(long shoppingcart_id,
                                      long good_id,
                                      int number,
                                      Date recordtime) {
        jdbc.update("UPDATE shoppingrecord SET  number = ? AND recordtime = ?  WHERE shoppingcart_id = ? AND good_id = ?",
                number,recordtime,shoppingcart_id, good_id);
    }

    public void deleteShoppingrecord(long shoppingcart_id, long good_id) {
        jdbc.update("DELETE from shoppingrecord  WHERE shoppingcart_id = ? AND good_id = ?",
                shoppingcart_id, good_id);
    }

    public class ShoppingrecordRowMapper implements RowMapper<Shoppingrecord> {
        @Override
        public Shoppingrecord mapRow(ResultSet rs, int rowNum) throws SQLException {
           Shoppingrecord shop = new Shoppingrecord();
           shop.setNumber(rs.getInt("number"));
           shop.setRecord_time(rs.getDate("record_time"));
           shop.setShoppingcart_id(rs.getLong("shoppingcart_id"));
           shop.setGood_id(rs.getLong("good_id"));
            return shop;
        }
    }

}

package com.tcat.dao;

import com.tcat.model.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lzw on 2017/7/18.
 */
public class ShoppingcartDao {
    @Autowired
    private JdbcTemplate jdbc;
    public Shoppingcart findShoppingcart(long shoppingcart_id) {
        List<Shoppingcart> query = jdbc.query("SELECT * FROM shoppingcart WHERE shoppingcart_id = ?",
                new ShoppingcartRowMapper(), shoppingcart_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<Shoppingcart> allShoppingcart()
    {
        List<Shoppingcart> query=jdbc.query("SELECT * FROM  shoppingcart",new ShoppingcartRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addShoppingcart(long shoppingcart_id,long user_id) {
        jdbc.update("INSERT INTO shoppingcart(shoppingcart_id,user_id) VALUE (?, ?)",shoppingcart_id,user_id);
    }

    public void deleteShoppingcart(long shoppingcart_id) {
        jdbc.update("DELETE from shoppingcart  WHERE shoppingcart_id = ?",
                shoppingcart_id);
    }

    public class ShoppingcartRowMapper implements RowMapper<Shoppingcart> {
        @Override
        public Shoppingcart mapRow(ResultSet rs, int rowNum) throws SQLException {
            Shoppingcart shop = new Shoppingcart();
            shop.setShoppingcart_id(rs.getLong("shoppingcart_id"));
            shop.setUser_id(rs.getLong("user_id"));
            return shop;
        }
    }
}

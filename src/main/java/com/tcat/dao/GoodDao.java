package com.tcat.dao;

import com.tcat.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lzw on 2017/7/18.
 */

@Repository
public class GoodDao {

    @Autowired
    private JdbcTemplate jdbc;
    public Good findgood(long good_id) {
        List<Good> query = jdbc.query("SELECT * FROM good WHERE good_id = ?",
                new GoodRowMapper(), good_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<Good> allGood()
    {
        List<Good> query=jdbc.query("SELECT * FROM good",new GoodRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addGood(long good_id,
             String good_name,
            double good_price,
             String good_imageurl,
             double good_discount,
             String good_description) {
        jdbc.update("INSERT INTO good(good_id,good_name,good_price,good_imageurl,good_discount,good_description) VALUE (?, ?, ?, ?, ?, ?, ?)", good_id,good_name,good_price,good_imageurl,good_discount,good_description);
    }

    public void modifyGood(long good_id,
                           String good_name,
                           double good_price,
                           String imageurl,
                           double discount,
                           String good_description) {
        jdbc.update("UPDATE good SET  good_name = ? AND good_price = ? AND good_imageurl = ? And discount = ? AND good_description = ? WHERE good_id = ?",
                good_name,good_price,imageurl,discount,good_description,good_id);
    }

    public void deleteGood(long good_id) {
        jdbc.update("DELETE from good  WHERE good_id = ?",
                good_id);
    }

    public class GoodRowMapper implements RowMapper<Good> {
        @Override
        public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
            Good good = new Good();
            good.setGood_id(rs.getLong("good_id"));
            good.setGood_name(rs.getString("good_name"));
            good.setGood_price(rs.getDouble("good_price"));
            good.setGood_description(rs.getString("good_description"));
            good.setImageurl(rs.getString("good_imageurl"));
            good.setDiscount(rs.getDouble("good_discount"));
            return good;
        }
    }
}

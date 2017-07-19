package com.tcat.dao;

import com.tcat.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lzw on 2017/7/18.
 */
public class AddressDao {

    @Autowired
    private JdbcTemplate jdbc;
    public Address findAddress(long address_id) {
        List<Address> query = jdbc.query("SELECT * FROM address WHERE product_id = ?",
                new AddressRowMapper(), address_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<Address> allAddress()
    {
        List<Address> query=jdbc.query("SELECT * FROM  address",new AddressRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addAddress(long address_id,long user_id,String address_data) {
        jdbc.update("INSERT INTO address(address_id,user_id,address_data) VALUE (?, ?, ?)", address_id,user_id,address_data);
    }

    public void modifyAddress(long address_id,String address_data) {
        jdbc.update("UPDATE address SET   address_data = ? WHERE address_id = ?",
               address_data,address_id);
    }

    public void deleteAddress(long address_id) {
        jdbc.update("DELETE from address  WHERE address_id = ?",
                address_id);
    }

    public class AddressRowMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setAddress_data(rs.getString("address_data"));
            address.setAddress_id(rs.getLong("address_id"));
            address.setUser_id(rs.getLong("user_id"));
            return address;
        }
    }
}

package com.tcat.dao;

import com.tcat.model.User;
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
public class UserDao {
    @Autowired
    private JdbcTemplate jdbc;
    public User findUser(long user_id) {
        List<User> query = jdbc.query("SELECT * FROM user WHERE user_id = ?",
                new UserRowMapper(), user_id);
        if (query != null && !query.isEmpty())
            return query.get(0);
        return null;
    }
    public List<User> allUser()
    {
        List<User> query=jdbc.query("SELECT * FROM  user",new UserRowMapper());
        if(query!=null&&!query.isEmpty())
        {
            return query;
        }
        else
            return null;
    }
    public void addUser(long user_id,
                        String user_name,
                        String user_password,
                        String user_tel,
                        String user_address,
                        String user_email,
                        Date regtime) {
        jdbc.update("INSERT INTO user(user_id,user_name,user_password,user_tel,user_address,user_email,regtime) VALUE (?, ?, ?, ?, ?, ?, ?)",
                user_id,user_name,user_password,user_tel,user_address,user_email,regtime);
    }

    public void modifyUser(long user_id,
                           String user_name,
                           String user_password,
                           String user_tel,
                           String user_address,
                           String user_email,
                           Date regtime) {
        jdbc.update("UPDATE user SET user_id = ? AND user_name = ? AND user_password = ? AND user_tel = ? AND user_address = ?  WHERE address_id = ?",
                user_name,user_password,user_tel,user_address,user_email,regtime,user_id);
    }

    public void deleteUser(long user_id) {
        jdbc.update("DELETE from user  WHERE user_id = ?",
                user_id);
    }

    public class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
           user.setUser_id(rs.getLong("user_id"));
           user.setUser_name(rs.getString("user_name"));
           user.setUser_password(rs.getString("user_password"));
           user.setUser_address(rs.getString("user_address"));
           user.setUser_email(rs.getString("user_email"));
           user.setUser_tel(rs.getString("user_tel"));
           user.setRegtime(rs.getDate("regtime"));
            return user;
        }
    }
}

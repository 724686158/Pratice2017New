package com.tcat.model;

import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * Created by lzw on 2017/7/18.
 */
public class User
{
    private  long user_id;
    private  String user_name;
    private  String user_password;
    private  String user_tel;
    private String user_address;
    private String user_email;
    private Date user_regtime;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getRegtime() {
        return user_regtime;
    }

    public void setRegtime(Date regtime) {
        this.user_regtime = regtime;
    }
}

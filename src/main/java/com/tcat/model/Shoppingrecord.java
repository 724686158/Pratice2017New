package com.tcat.model;

import java.sql.Date;

/**
 * Created by lzw on 2017/7/18.
 */
public class Shoppingrecord {
    private  long user_id;
    private long shoppingcart_id;
    private int number;
    private Date record_time;

    public Shoppingrecord() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getShoppingcart_id() {
        return shoppingcart_id;
    }

    public void setShoppingcart_id(long shoppingcart_id) {
        this.shoppingcart_id = shoppingcart_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }
}

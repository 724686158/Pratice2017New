package com.tcat.model;

import java.sql.Date;

/**
 * Created by lzw on 2017/7/18.
 */
public class Shoppingrecord {
    private  long good_id;
    private long shoppingcart_id;
    private int number;
    private Date record_time;

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
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

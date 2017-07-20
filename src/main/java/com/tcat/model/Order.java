package com.tcat.model;

import java.sql.Date;

/**
 * Created by lzw on 2017/7/18.
 */
public class Order
{
    private long order_id;
    private Date order_createtime;
    private String order_state;
    private String order_delivery;
    private long user_id;
    private long good_id;
    private int number;
    private double cost;

    public Date getOrder_createtime() {
        return order_createtime;
    }

    public void setOrder_createtime(Date order_createtime) {
        this.order_createtime = order_createtime;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getOrder_delivery() {
        return order_delivery;
    }

    public void setOrder_delivery(String order_delivery) {
        this.order_delivery = order_delivery;
    }
}

package com.tcat.bean;

import java.sql.Date;

/**
 * Created by mengzicheng on 2017/7/21.
 */
public class OrderInfo {

    private long order_id;
    private String good_name;
    private int number;
    private double cost;
    private String order_state;
    private String order_delivery;
    private Date order_createtime;

    public OrderInfo(long order_id, String good_name, int number, double cost, String order_state, String order_delivery, Date order_createtime) {
        this.order_id = order_id;
        this.good_name = good_name;
        this.number = number;
        this.cost = cost;
        this.order_state = order_state;
        this.order_delivery = order_delivery;
        this.order_createtime = order_createtime;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
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

    public Date getOrder_createtime() {
        return order_createtime;
    }

    public void setOrder_createtime(Date order_createtime) {
        this.order_createtime = order_createtime;
    }
}

package com.tcat.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Good {
    private long good_id;
    private String good_name;
    private double good_price;
    private String imageurl;
    private double discount;
    private String good_description;

    public Good(String good_name, double good_price, String imageurl) {
        this.good_name = good_name;
        this.good_price = good_price;
        this.imageurl = imageurl;
    }

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getGood_description() {
        return good_description;
    }

    public void setGood_description(String good_description) {
        this.good_description = good_description;
    }
}

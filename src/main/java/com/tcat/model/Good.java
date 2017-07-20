package com.tcat.model;

import java.sql.Date;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Good {
    private long good_id;
    private String good_name;
    private double good_price;
    private String good_imageurl;
    private double good_discount;
    private String good_description;

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
        return good_imageurl;
    }

    public void setImageurl(String imageurl) {
        this.good_imageurl = imageurl;
    }

    public double getDiscount() {
        return good_discount;
    }

    public void setDiscount(double discount) {
        this.good_discount = discount;
    }

    public String getGood_description() {
        return good_description;
    }

    public void setGood_description(String good_description) {
        this.good_description = good_description;
    }

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", good_name='" + good_name + '\'' +
                ", good_price=" + good_price +
                ", good_imageurl='" + good_imageurl + '\'' +
                ", good_discount=" + good_discount +
                ", good_description='" + good_description + '\'' +
                '}';
    }
}

package com.tcat.bean;

/**
 * Created by mengzicheng on 2017/7/21.
 */
public class ShoppingcartInfo {
    private String goodName;
    private String imageUrl;
    private int number;
    private double price;

    public ShoppingcartInfo(String goodName, String imageUrl, int number, double price) {
        this.goodName = goodName;
        this.imageUrl = imageUrl;
        this.number = number;
        this.price = price;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

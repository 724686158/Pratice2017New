package com.tcat.model;

/**
 * Created by lzw on 2017/7/18.
 */
public class Address {

    private long address_id;
    private long user_id;
    private String address_data;

    public Address() {
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getAddress_data() {
        return address_data;
    }

    public void setAddress_data(String address_data) {
        this.address_data = address_data;
    }
}


package com.tcat.model;

/**
 * Created by lzw on 2017/7/18.
 */
public class Shoppingcart {
    private long shoppingcart_id;
    private long user_id;

    public Shoppingcart() {
    }

    public long getShoppingcart_id() {
        return shoppingcart_id;
    }

    public void setShoppingcart_id(long shoppingcart_id) {
        this.shoppingcart_id = shoppingcart_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}

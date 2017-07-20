package com.tcat.controller;

/**
 * Created by mengzicheng on 2017/7/14.
 */
import com.tcat.dao.*;
import com.tcat.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }

    @Autowired
    private AddressDao addressDao;
    @RequestMapping("/AllAddress")
    @ResponseBody
    List<Address> AllAddress() {
        return addressDao.allAddress();
    }

    @Autowired
    private GoodDao goodDao;
    @RequestMapping("/AllGood")
    @ResponseBody
    List<Good> AllGood() {
        return goodDao.allGood();
    }

    @Autowired
    private OrderDao orderDao;
    @RequestMapping("/AllOrder")
    @ResponseBody
    List<Order> AllOrder() {
        return orderDao.allOrder();
    }

    @Autowired
    private ShoppingcartDao shoppingcartDao;
    @RequestMapping("/AllShoppingcart")
    @ResponseBody
    List<Shoppingcart> AllShoppingcart() {
        return shoppingcartDao.allShoppingcart();
    }

    @Autowired
    private UserDao userDao;
    @RequestMapping("/AllUser")
    @ResponseBody
    List<User> AllUser() {
        return userDao.allUser();
    }
}
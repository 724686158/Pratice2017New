package com.tcat.controller;

/**
 * Created by mengzicheng on 2017/7/14.
 */
import com.tcat.bean.ShoppingcartInfo;
import com.tcat.dao.*;
import com.tcat.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private GoodDao goodDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShoppingcartDao shoppingcartDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingrecordDao shoppingrecordDao;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "htmlviews/index.html";
    }

    @RequestMapping("/login")
    @ResponseBody
    String login(HttpServletRequest request) {
        String user_id = request.getParameter("user_id");
        String user_password = request.getParameter("user_password");
        List<User> users = userDao.allUser();
        User user = userDao.findUser(Long.parseLong(user_id));
        if (user != null){
            return user_id;
        }else {
            return "FAIL";
        }
    }

    @RequestMapping("/hello")
    @ResponseBody
    Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }

    @RequestMapping("/AllAddress")
    @ResponseBody
    List<Address> AllAddress() {
        return addressDao.allAddress();
    }


    @RequestMapping("/AllGood")
    @ResponseBody
    List<Good> AllGood() {
        return goodDao.allGood();
    }


    @RequestMapping("/AllOrder")
    @ResponseBody
    List<Order> AllOrder() {
        return orderDao.allOrder();
    }

    @RequestMapping("/AllShoppingcart")
    @ResponseBody
    List<Shoppingcart> AllShoppingcart() {
        return shoppingcartDao.allShoppingcart();
    }

    // 获取购物车实际信息
    @RequestMapping("/ShoppingcartInfos")
    @ResponseBody
    List<ShoppingcartInfo> ShoppingcartInfos(HttpServletRequest request) {

        List<ShoppingcartInfo> ans = new ArrayList<ShoppingcartInfo>();
        String user_id = request.getParameter("user_id");

        List<Shoppingcart> shoppingcarts = shoppingcartDao.allShoppingcart();
        List<Shoppingrecord> shoppingrecords = shoppingrecordDao.allShoppingrecord();

        int size = shoppingcarts.size();
        for(int i = 0;i < size; i++){
            if(shoppingcarts.get(i).getUser_id() == Long.parseLong(user_id)){
                long Shoppingcart_id = shoppingcarts.get(i).getShoppingcart_id();
                int shoppingrecords_size = shoppingrecords.size();
                for(int j = 0; j < shoppingrecords_size; j++){
                    if(shoppingrecords.get(j).getShoppingcart_id() == Shoppingcart_id){
                        Good good = goodDao.findgood(shoppingrecords.get(j).getGood_id());
                        ShoppingcartInfo shoppingcartInfo = new ShoppingcartInfo(good.getGood_name(), good.getImageurl(), shoppingrecords.get(j).getNumber(), good.getGood_price());
                        ans.add(shoppingcartInfo);
                    }
                }
            }
        }
        return ans;
    }


    @RequestMapping("/AllUser")
    @ResponseBody
    List<User> AllUser() {
        return userDao.allUser();
    }
}
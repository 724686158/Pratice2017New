package com.tcat.controller;

import com.tcat.dao.UserDao;
import com.tcat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    @ResponseBody
    private User login(HttpServletRequest request)
    {
        String username = request.getParameter("userid");
        String password = request.getParameter("password");
        //System.out.println(username+" "+password);
        List<User> userList = userDao.allUser();
        Iterator<User> useriterator = userList.iterator();
        User user;
        long id = -1;
        while(useriterator.hasNext()) {
            user = useriterator.next();
            if (user.getUser_email().equals(username) && user.getUser_password().equals(password)) {
                id = user.getUser_id();
                break;
            }
        }
        if(id >= 0) {
            user = userDao.findUser(id);
        }
        else {
            user = null;
        }
        return user;
    }
}

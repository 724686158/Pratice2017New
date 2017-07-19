package com.tcat.controller;

/**
 * Created by mengzicheng on 2017/7/14.
 */
import com.tcat.model.Good;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }

    @RequestMapping("/products")
    @ResponseBody
     ArrayList<Good> products() {
        ArrayList<Good> ps;
        ps = new ArrayList<Good>();
        ps.add(new Good("探路者跑步鞋", 599.00, "http://img3x7.ddimg.cn/98/28/1316289347-1_k_1.jpg"));
        ps.add(new Good("品胜 10000毫安 移动电源", 95.00, "https://img11.360buyimg.com/n1/jfs/t3202/122/9474814023/314096/cce5ece6/58d38f1fN2058d702.jpg"));
        ps.add(new Good("东芝SD卡16G内存卡", 54.90, "https://img13.360buyimg.com/n1/jfs/t3946/125/460549879/234074/8eba86ae/5850b92eNe41bf399.jpg"));
        ps.add(new Good("小米（MI）体重秤", 199.00, "https://img14.360buyimg.com/n1/jfs/t3184/68/7668965960/109436/551f4d7f/58ba298cNdbace5b2.jpg"));
        return ps;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
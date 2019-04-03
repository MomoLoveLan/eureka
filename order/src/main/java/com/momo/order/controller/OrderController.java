package com.momo.order.controller;

import com.momo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-02 14:49
 */
@RestController
@RequestMapping(value = "/*")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping(value = "getUserList")
    public List getUserList(){
        return orderService.getUserList();
    }

    @GetMapping(value = "getUserTest")
    public String getUserTest(){
        return "我是order模块的getUserTest";
    }

    @GetMapping(value = "getHystrix")
    public String getHystrix(){
        return orderService.getHystrix();
    }
}

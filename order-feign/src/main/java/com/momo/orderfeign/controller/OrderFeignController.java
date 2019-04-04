package com.momo.orderfeign.controller;

import com.momo.orderfeign.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-02 14:49
 */
@RestController
@RequestMapping(value = "/*")
public class OrderFeignController {


    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping(value = "getUserList")
    public List getUserList(){
        return orderFeignService.getUserList();
    }

    @GetMapping(value = "getUserTest")
    public String getUserTest(){
        return "我是orderFeign模块的getUserTest";
    }

    @GetMapping(value = "getHystrix")
    public String getHystrix(){
        return orderFeignService.getHystrix();
    }
}

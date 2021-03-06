package com.momo.user.controller;

import org.springframework.beans.factory.annotation.Value;
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
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "getUserList")
    public List getUserList(){
        List list = new ArrayList();
        list.add("abcd");
        list.add(serverPort);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        return list;
    }
    @GetMapping(value = "getUserTest")
    public String getUserTest(){
        return "我是user模块的getUserTest";
    }
}

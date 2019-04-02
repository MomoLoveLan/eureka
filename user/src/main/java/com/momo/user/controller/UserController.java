package com.momo.user.controller;

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

    @GetMapping(value = "getUserList")
    public List getUserList(){
        List list = new ArrayList();
        list.add("abcd");
        return list;
    }
}

package com.momo.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-02 15:02
 */
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;
    public List getUserList(){
        List list = restTemplate.getForObject("http://eureka-user/getUserList", List.class);
        return list;
    }
}

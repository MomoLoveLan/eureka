package com.momo.orderfeign.service;

import com.momo.orderfeign.mapper.OrderFeignMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-02 15:02
 */
@Service
public class OrderFeignService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderFeignMapper orderFeignMapper;

    public List getUserList(){
        List list = orderFeignMapper.getUserList();
        System.out.println("Feign 工程调用 user 成功");
        return list;
    }

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String getHystrix(){

        return restTemplate.getForObject("http://eureka-user/getUserList", List.class).get(1).toString();
    }

    public String helloFallBack(){
        return orderFeignMapper.getError();
    }
}

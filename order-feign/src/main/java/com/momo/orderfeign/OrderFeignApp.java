package com.momo.orderfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApp.class, args);
    }

    /**
     * 在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；
     * 并且向程序的ioc注入一个bean: restTemplate;
     * 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
     */
    @Bean  //加入到IOC容器
    @LoadBalanced  //开启负载均衡功能
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

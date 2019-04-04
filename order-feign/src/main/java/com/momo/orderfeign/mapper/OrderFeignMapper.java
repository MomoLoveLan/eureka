package com.momo.orderfeign.mapper;

import com.momo.orderfeign.feign.FeignClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-04 09:41
 */
@FeignClient(value = "eureka-user",fallbackFactory = FeignClientFallBackFactory.class)
public interface OrderFeignMapper {

    @RequestMapping("/getUserList")
    List getUserList();

    String getError();
}

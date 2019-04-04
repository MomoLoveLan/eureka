package com.momo.orderfeign.feign;

import com.momo.orderfeign.mapper.OrderFeignMapper;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: eureka
 * @description:
 * @author: zhanghui2018
 * @create: 2019-04-04 15:31
 *  解耦与降级处理
 *
 * 1.何为降级：
 *     - 当系统整体资源快不够的时候，忍痛将部分服务暂时关闭，待渡过难关后，再重新开启。
 *     - 降级处理是在【客户端】完成的，与服务端没有关系
 *     - 理解：所谓降级，一般是从【整体负荷】考虑，当某个服务熔断之后，服务器将不再被调用，
 *          此时客户端可以自己准备一个本地的FallBack回调，返回 一个缺省值。
 *          这样做虽然服务水平下降，但好歹可用，比直接挂掉好。
 *
 * 2.为什么要解耦？
 *      如果按照上面的熔断案例来做的话，Controller下的每个方法，都要给其编写一个FallBack方法，
 *      当方法慢慢变多，就会造成代码膨胀，一个是增加编写的工作量，另外一个也会增大维护的难度，
 *      代码的耦合度也会高，是十分不合理的，所以要将其解耦。
 * 3.解耦思路：
 *       因为服务端的是通过实现接口访问服务端的，如果在父接口上实现了FallBack方法，
 *       通过这样一种方式去维护起来就能实现解耦，也顺便完成了降级的机制。
 *
 */
@Component
public class FeignClientFallBackFactory implements FallbackFactory<OrderFeignMapper> {
    @Override
    public OrderFeignMapper create(Throwable throwable) {
        return new OrderFeignMapper() {
            @Override
            public List getUserList() {
                // 服务降级处理
                List list = new ArrayList<>();
                list.add("服务发生异常......已降级111");
                return list;
            }

            @Override
            public String getError() {
                return null;
            }
        };
    }
}



#### eureka

* server模块：Eureka服务注册
* user模块：获取用户列表模块
* users模块：user模块的复制品，主要做负载均衡
* order模块：订单获取用户个人信息模块
* Eureka-zuul模块：注册服务中心

#### 使用到的组件 
* eureka:提供服务注册和发现
* ribbon: 实现负载均衡
* feign: 和Eureka结合，默认集成ribbon
* zuul: 路由网关，路由转发和过滤器。
zuul默认和ribbon结合实现了负载均衡的功能，类似于nginx转发。
* Hystrix 服务容错保护机制，使用接口地址访问时可以实现熔断，使用zuul接口网关后悔失效。
#### 注意
* 在定义zuul模块时不能以zuul为名，会有冲突。


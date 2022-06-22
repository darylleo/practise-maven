package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/look")
    public String look() {
        //1.RestTemplate模拟浏览器发送请求给用户微服务 获取用户的信息
        //1.1 创建restTempalte 交给spring容器管理
        //1.2 直接注入使用 调用get方法获取用户的信息
        //User user = restTemplate.getForObject("http://localhost:18081/user/2", User.class);
        //从eureka注册中心中动态的获取IP和端口 拼接
        //参数 指定serviceid 就是注册到注册中心微服务的服务名（spring.application.name指定的那个值）
        //List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        //ip 和port都在ServiceInstance中

        //ServiceInstance serviceInstance = instances.get(0);

        //User user = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/2", User.class);

        //负载均衡
        // 1. 加入ribbon 的起步依赖
        // 2. 加入注解修饰RestTemplate
        // 3. 直接使用
        User user = restTemplate.getForObject("http://user-provider/user/2", User.class);

        //CTR +P
        System.out.println(user.getName() + ":" + user.getId());
        //2.判断用户是否正确 下单成功 返回成功标识
        return "ok";
    }
}

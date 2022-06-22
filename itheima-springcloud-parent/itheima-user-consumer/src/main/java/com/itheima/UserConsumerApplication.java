package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableEurekaClient//启用eureka client 自动进行注册
//@EnableDiscoveryClient//启用服务注册于发现
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced//启动负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

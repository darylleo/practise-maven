package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableJpaRepositories//开启jpa的使用 自动进行配置了
//启用eureka的client 会自动的进行注册
@EnableEurekaClient
public class UserProviderApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication2.class, args);
    }
}

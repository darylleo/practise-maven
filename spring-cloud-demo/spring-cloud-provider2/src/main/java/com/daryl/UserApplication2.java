package com.daryl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author wl
 * @create 2022-01-05
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class UserApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication2.class, args);
    }
}

package com.daryl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wl
 * @create 2022-01-11
 */
@SpringBootApplication
public class MyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
        //System.out.println(context.getBean("userEntity"));
    }
}

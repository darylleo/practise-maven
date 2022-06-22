package com.daryl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wl
 * @create 2022-01-14
 */
@SpringBootApplication
@EnableScheduling
public class DarylApplication {
    public static void main(String[] args) {
        SpringApplication.run(DarylApplication.class, args);
    }
}

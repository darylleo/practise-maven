package com.daryl.api;

import com.daryl.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @create 2022-01-10
 */
@RestController
@RequestMapping("/feign")
public class ConsumerFeignApi {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/find")
    public Object findAll(){
        return userClient.findAll();
    }
}

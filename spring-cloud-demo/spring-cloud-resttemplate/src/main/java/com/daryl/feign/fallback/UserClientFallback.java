package com.daryl.feign.fallback;

import com.daryl.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @create 2022-01-10
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public String findAll() {
        return "服务降级";
    }
}

package com.daryl.feign;

import com.daryl.feign.fallback.UserClientFallback;
import com.daryl.feign.util.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wl
 * @create 2022-01-10
 */
@FeignClient(value = "user-provider",fallback = UserClientFallback.class,configuration = FeignConfig.class)
public interface UserClient {

    @RequestMapping("/user/find")
    String findAll();
}

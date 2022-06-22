package com.daryl.feign.util;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wl
 * @create 2022-01-10
 */
@Configuration
public class FeignConfig {
    /**
     * feign支持四种级别
     *  NONE:不记录任何日志（默认值）
     *  BASIC:仅记录请求的方法，URL响应状态码和执行时间
     *  HEADERS:在BASIC基础上，额外记录了请求和响应的头信息
     *  FULL：记录所有请求和响应的明细，包括头信息、请求体、元数据
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }
}

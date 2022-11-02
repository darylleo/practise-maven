package com.daryl.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @create 2022-02-09
 */
@RestController
@RequestMapping("/api")
public class WebTestApi {

    @RequestMapping("/test")
    public String jsonTest() {
        return null;
    }
}

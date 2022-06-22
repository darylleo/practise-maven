package com.daryl.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wl
 * @create 2022-01-04
 */
@RestController
@RequestMapping("/user")
public class TestApi {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "testFallBack")
    public Object test() {
        String url = "http://user-provider/find";
        //String url = "http://127.0.0.1:18081/find";

/*        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        ServiceInstance userProvider = instances.get(0);
        String url = "http://" + userProvider.getHost() + ":" + userProvider.getPort() +"/find";*/
        String data = restTemplate.getForObject(url, String.class);
        //System.out.println(data);
        return data;
    }

    public Object testFallBack(){
        return "服务降级";
    }
}

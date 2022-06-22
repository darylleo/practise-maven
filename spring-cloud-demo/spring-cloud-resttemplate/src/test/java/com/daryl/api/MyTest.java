package com.daryl.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @create 2022-01-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test01(){
        String url = "http://user-provider/find";
        String data = restTemplate.getForObject(url, String.class);
        int i = 0;
        //System.out.println(data);
        while (i==100){
            System.out.println(i+":"+restTemplate.getForObject(url, String.class));
            i ++;
        }

    }
}

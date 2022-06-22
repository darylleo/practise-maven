package com.daryl.api;

import com.daryl.service.LinkmanService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @create 2022-01-05
 */
@RestController
@RequestMapping("/user")
public class LinkmanApi {
    @Autowired
    private LinkmanService linkmanService;

    @RequestMapping("/find/{id}")
    public Object findAll(@PathVariable(value = "id") Integer id){
        //return linkmanService.findAll();
        //String s = "提供者2号---------------------------------------------------";
        return linkmanService.findById(id);
    }
}

package com.daryl.api;

import com.daryl.pojo.User;
import com.daryl.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;

/**
 * @author wl
 * @create 2022-01-04
 */
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private LinkmanService linkmanService;

/*    @RequestMapping("/find")
    public Object findUser(){
        User user = new User();
        user.setName("张三丰");
        user.setId(111);
        user.setRemark("tell me why!!");
        user.setGender("mail");
        return user;
    }*/

    @RequestMapping("/find/{id}")
    public Object findUser(@PathVariable(value = "id") Integer id){
        //linkmanService.findAll();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return linkmanService.findById(id);
    }
}

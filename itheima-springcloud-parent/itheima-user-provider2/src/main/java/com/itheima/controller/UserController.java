package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //根据用户的ID 获取用户
    @GetMapping("/{id}")
    public User findById(@PathVariable(name="id")Integer id){

        System.out.println("=====================2============被调用");
        return userService.findById(id);
    }
}

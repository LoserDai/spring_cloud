package com.df.controller;

import com.df.feign.UserFeign;
import com.df.pojo.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loser
 * @date 2021年11月15日 12:45
 */
@RestController
public class UserController {
    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/user/getUser")
    public User getUser(){
        return userFeign.getUser();
    }
}

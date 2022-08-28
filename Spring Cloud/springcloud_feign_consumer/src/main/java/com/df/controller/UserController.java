package com.df.controller;

import com.df.feign.UserFeign;
import com.df.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loser
 * @date 2021年11月13日 15:30
 */
@RestController
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/user/getUser")
    public User getUser(){
        return userFeign.getUser();
    }

    @RequestMapping("/user/getUser1")
    public User getUser1( Integer id){
        return userFeign.getUser1(id);
    }

    @RequestMapping("/user/getUser2/{id}")
    public User getUser2(@PathVariable Integer id){
        return userFeign.getUser2(id);
    }

    @RequestMapping("/user/getUser3")
    public User getUser3(User user){
        user = new User(234,"李逍遥",1);
        return userFeign.getUser3(user);
    }
}

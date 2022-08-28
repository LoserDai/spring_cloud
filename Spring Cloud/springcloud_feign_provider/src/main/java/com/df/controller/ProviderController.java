package com.df.controller;

import com.df.pojo.User;
import com.df.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loser
 * @date 2021年11月12日 15:06
 */
@RestController
public class ProviderController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/getUser")
    public User getUser(){
        return userService.getUser();
    }

}

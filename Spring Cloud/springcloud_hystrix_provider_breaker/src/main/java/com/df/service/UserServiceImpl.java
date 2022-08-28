package com.df.service;

import com.df.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Loser
 * @date 2021年11月15日 12:51
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public User getUser() {
        System.out.println("=========>" + new Date());
        //throw new RuntimeException("瞎扯淡!!!!");
        return new User(1,"李逍遥",23);
    }
}

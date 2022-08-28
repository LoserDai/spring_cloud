package com.df.service;

import com.df.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Loser
 * @date 2021年11月16日 19:12
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public User getUser(Integer id){
        return new User(id,"李逍遥",22);
    }
}

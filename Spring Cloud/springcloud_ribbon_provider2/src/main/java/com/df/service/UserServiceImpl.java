package com.df.service;

import com.df.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author Loser
 * @date 2021年11月12日 14:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Integer id){
        return new User(id,"Jerry",17);
    }
}

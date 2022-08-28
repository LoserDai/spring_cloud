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
    public User getUser(){
        /*try {
            //模拟feign超时,需要配置超时时间
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new User(222,"Tom",18);
    }
}

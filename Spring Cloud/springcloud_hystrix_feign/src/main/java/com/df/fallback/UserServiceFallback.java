package com.df.fallback;

import com.df.feign.UserFeign;
import com.df.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import feign.hystrix.FallbackFactory;


import org.springframework.stereotype.Component;


/**
 * @author Loser
 * @date 2021年11月15日 12:36
 */
//降级逻辑
@Component
public class UserServiceFallback implements FallbackFactory<UserFeign>/*UserFeign*/ {
    /*@Override
    public User getUser() {
        return new User(1,"我是托底",12);
    }*/
    private Logger logger = LoggerFactory.getLogger(UserServiceFallback.class);
    @Override
    public UserFeign create(Throwable throwable) {
        logger.warn("=====FallbackException====: ",throwable);
        return new UserFeign() {
            @Override
            public User getUser() {
                return new User(0,"我是托底",12);
            }
        };
    }
}

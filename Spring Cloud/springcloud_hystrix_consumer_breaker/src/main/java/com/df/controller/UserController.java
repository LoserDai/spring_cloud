package com.df.controller;

import com.df.feign.UserFeign;
import com.df.pojo.User;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*@HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    //错误百分比条件，达到熔断器最小请求数后错误率达到百分之多少后打开熔断器
                    @HystrixProperty(name =
                    HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "5"),
                    //断容器最小请求数，达到这个值过后才开始计算是否打开熔断器
                    @HystrixProperty(name =
                    HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "3"),
                    // 默认5秒; 熔断器打开后多少秒后 熔断状态变成半熔断状态(对该微服务进行一次请求尝试，不成功则状态改成熔断，成功则关闭熔断器
                    @HystrixProperty(name =
                    HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000")
            })*/

    @RequestMapping("/user/getUser")
    public User getUser(){
        return userFeign.getUser();
    }

    public User fallback(){
        return new User(1,"托底",22);
    }
}

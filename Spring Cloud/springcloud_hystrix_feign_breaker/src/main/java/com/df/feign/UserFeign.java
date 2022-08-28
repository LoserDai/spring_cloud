package com.df.feign;


import com.df.fallback.UserServiceFallback;
import com.df.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//获取hystrix-provider的调用地址，且具有负载均衡的能力
//@FeignClient(value = "hystrix-provider")
//@FeignClient(value = "hystrix-provider",fallback = UserServiceFallback.class)
@FeignClient(value = "hystrix-provider",fallbackFactory = UserServiceFallback.class)
public interface UserFeign {
    @RequestMapping(value = "/user/getUser")
    public User getUser();
}

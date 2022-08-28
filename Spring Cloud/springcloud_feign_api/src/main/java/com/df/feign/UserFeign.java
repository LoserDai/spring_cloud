package com.df.feign;

import com.df.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//获取feign-provider的调用地址，且具有负载均衡的能力
@FeignClient("feign-provider")
public interface UserFeign {

    @RequestMapping("/user/getUser")
    public User getUser();

    /**
     * @RequestMapping: 存url
     * @RequestParam:   以 ? 的形式拼接参数
     */
    @RequestMapping("/user/getUser1")
    User getUser1(@RequestParam Integer id);

    /**
     *
     *@RequestMapping: 存url
     *@PathVariable: 以 '/' 的形式拼接参数
     */
    @RequestMapping("/user/getUser2/{id}")
    User getUser2(@PathVariable Integer id);

    /**
     *
     * @RequestMapping: 存url
     * @RequestBody: 把 user 转化成 json
     */
    @RequestMapping("/user/getUser3")
    User getUser3(@RequestBody User user);
}

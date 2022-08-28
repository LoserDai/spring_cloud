package com.df.controller;

import com.df.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Loser
 * @date 2021年11月13日 11:21
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    //从eureka注册中心获取服务端的ip、端口、要调用的服务
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "consumer/user/{id}",method= RequestMethod.GET)
    public User getUser(@PathVariable Integer id){
        ServiceInstance si = loadBalancerClient.choose("ribbon-provider");
        String url = "http://" + si.getHost() + ":" + si.getPort() + "/user/" + id;
        return restTemplate.getForObject(url,User.class);
    }
}

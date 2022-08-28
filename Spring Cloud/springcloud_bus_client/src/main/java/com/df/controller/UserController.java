package com.df.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loser
 * @date 2021年11月16日 19:32
 */
@RestController
//自动刷新配置，重新从BeanFactory获取一个新的实例（该实例使用新的配置）
@RefreshScope
public class UserController {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName: " + applicationName + "<br> eurekaServers:" +
                eurekaServers + "<br> port: " + port;
    }
}

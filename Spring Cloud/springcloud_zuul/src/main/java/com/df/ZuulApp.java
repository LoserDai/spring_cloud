package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Loser
 * @date 2021年11月15日 17:51
 */
@SpringBootApplication
@EnableZuulProxy // 开启网关
@EnableEurekaClient //允许向微服务注册服务
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }
}

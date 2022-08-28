package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Loser
 * @date 2021年11月16日 19:15
 */
@SpringBootApplication
@EnableEurekaClient //允许向服务端注册服务
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class);
    }
}

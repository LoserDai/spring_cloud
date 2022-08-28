package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Loser
 * @date 2021年11月12日 15:18
 */
@SpringBootApplication
@EnableEurekaClient  //允许向注册中心注册该服务，并可以获取其他服务的调用地址
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class);
    }
}

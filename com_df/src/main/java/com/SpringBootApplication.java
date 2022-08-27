package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feng.dai
 * @Package com
 * @date 2022/8/27 10:50
 */

@RestController
@SpringBootConfiguration
@EnableAutoConfiguration
public class SpringBootApplication {

    @RequestMapping("/")
    public String home(){
        return "hello world~";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}

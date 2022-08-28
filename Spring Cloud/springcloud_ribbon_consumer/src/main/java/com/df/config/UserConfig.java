package com.df.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Loser
 * @date 2021年11月13日 11:42
 */
@Configuration
public class UserConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    /**
     *ribbon随机策略 ,默认的是轮询策略
     */
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }
}

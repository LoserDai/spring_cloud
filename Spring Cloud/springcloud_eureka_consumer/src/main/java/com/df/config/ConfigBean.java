package com.df.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Loser
 * @date 2021年11月12日 15:21
 */
@Configuration
public class ConfigBean {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

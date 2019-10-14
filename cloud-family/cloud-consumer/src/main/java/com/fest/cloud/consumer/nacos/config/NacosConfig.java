package com.fest.cloud.consumer.nacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 17:19
 * @Description:
 */
@Configuration
public class NacosConfig implements Config {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}

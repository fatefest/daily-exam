package com.fest.cloud.provider.nacos;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yesitao
 * @Date: 2019/9/10 17:50
 * @Description: 11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

}

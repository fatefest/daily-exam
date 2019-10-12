package com.fest.cloud.consumer.nacos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: yesitao
 * @Date: 2019/9/10 17:50
 * @Description: 11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NacosConsumerApplication.class,args);
    }
}

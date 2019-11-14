package com.fest.cloud.consumer.nacos;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: yesitao
 * @Date: 2019/9/10 17:50
 * @Description: 11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.fest.cloud.consumer.nacos.mapper")
public class NacosConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NacosConsumerApplication.class, args);
    }
}

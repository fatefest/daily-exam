package com.fest.exam.dubbo.consumer;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: yesitao
 * @Date: 2019/4/30 14:23
 * @Description: 启动类
 */

@EnableDubbo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class})
@EnableWebMvc
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class,args);
    }
}

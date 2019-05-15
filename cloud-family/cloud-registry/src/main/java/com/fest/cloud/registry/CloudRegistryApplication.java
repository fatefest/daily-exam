package com.fest.cloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author yesitao
 * @date 2019-5-15
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRegistryApplication.class, args);
    }

}

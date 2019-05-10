package com.fest.exam.dubbo.provider;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.fest.exam.dubbo.api.HelloService;
import com.fest.exam.dubbo.service.impl.HelloServiceImpl;

import java.io.IOException;

/**
 * @Author: yesitao
 * @Date: 2019/4/29 9:56
 * @Description: 测试合伙人服务
 */
public class DubboProvider {


    public static void main(String[] args) {
        ServiceConfig<HelloService> serviceConfig = new ServiceConfig<HelloService>();
        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setInterface(HelloService.class);
        serviceConfig.setRef(new HelloServiceImpl());
        serviceConfig.export();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

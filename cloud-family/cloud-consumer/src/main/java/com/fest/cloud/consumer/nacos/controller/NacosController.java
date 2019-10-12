package com.fest.cloud.consumer.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fest.cloud.consumer.nacos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 16:51
 * @Description:
 */
@RestController
public class NacosController{

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    @Value("${spring.application.name}")
    private String appName;

    private String testName;

    @GetMapping("/echo/app-name")
    @SentinelResource
    public String echoAppName(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        testName = applicationContext.getEnvironment().getProperty("user.name");
//        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
//        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName+"|"+testName);
//        System.out.println("request path:" +path);

        return testService.echo(testName);
    }

}
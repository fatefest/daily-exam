package com.fest.cloud.consumer.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fest.cloud.common.domain.entity.CloudUser;
import com.fest.cloud.consumer.nacos.service.LocalUserService;
import com.fest.cloud.consumer.nacos.service.RestService;
import com.fest.cloud.dubbo.service.NameService;
import com.fest.cloud.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 16:51
 * @Description:
 */
@RestController
public class NacosController {

    @Resource
    private RestService restService;
    @Autowired
    private ApplicationContext applicationContext;
    @Reference(check = false)
    private NameService nameService;
    @Value("${spring.application.name}")
    private String appName;

    @Value("${user.name}")
    private String testName;

    @Resource
    private LocalUserService localUserService;

    @GetMapping("/echo/app-name")
    @SentinelResource
    public String echoAppName() {
        return restService.echo(testName);
    }

    @GetMapping("/name")
    public String getName() {

        return nameService.myName();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody CloudUser user){
        localUserService.saveUser(user);
    }

}
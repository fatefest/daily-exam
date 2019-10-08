package com.fest.exam.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yesitao
 * @Date: 2019/10/8 9:50
 * @Description: 测试接口
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/callback")
    public void callback(@RequestBody String message){
        System.out.println("接收到信息：" + message);
    }
}

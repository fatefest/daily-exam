package com.fest.cloud.consumer.nacos.service.impl;

import com.fest.cloud.consumer.nacos.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 17:15
 * @Description: test
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public String echo(String name) {
        return "echo fallback";
    }
}

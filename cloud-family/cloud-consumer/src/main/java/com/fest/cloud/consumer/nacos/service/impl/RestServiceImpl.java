package com.fest.cloud.consumer.nacos.service.impl;

import com.fest.cloud.consumer.nacos.service.RestService;
import org.springframework.stereotype.Service;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 17:15
 * @Description: test
 */
@Service
public class RestServiceImpl implements RestService {


    @Override
    public String echo(String name) {
        return "echo fallback";
    }
}

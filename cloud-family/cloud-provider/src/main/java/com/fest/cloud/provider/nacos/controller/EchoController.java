package com.fest.cloud.provider.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yesitao
 * @Date: 2019/10/12 16:54
 * @Description:
 */
@RestController
class EchoController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return string;
    }
}

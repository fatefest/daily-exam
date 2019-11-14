package com.fest.cloud.consumer.nacos.service;

import com.fest.cloud.consumer.nacos.service.impl.RestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 测试
 */
@FeignClient(name = "service-provider", fallback = RestServiceImpl.class)
public interface RestService {

    @GetMapping("/echo/{name}")
    String echo(@PathVariable("name") String name);
}

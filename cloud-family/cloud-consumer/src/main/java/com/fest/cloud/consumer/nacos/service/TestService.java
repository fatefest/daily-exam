package com.fest.cloud.consumer.nacos.service;

import com.fest.cloud.consumer.nacos.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 测试
 */
@FeignClient(name = "service-provider", fallback = TestServiceImpl.class)
public interface TestService {

    @GetMapping("/echo/{name}")
    String echo(@PathVariable("name") String name);
}

package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.yunche.activiti.Vo.ActivitiVo;
import com.yunche.activiti.service.ActivitiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yesitao
 * @Date: 2019/10/25 11:00
 * @Description:
 */
@RestController
@RequestMapping("/activit")
public class DubboActitiController {

    @Reference(version = "1.0.0")
    private ActivitiService activitiService;

    @GetMapping("/start")
    public JSONObject start(
            @RequestParam("customerId") Long customerId,
            @RequestParam("orderId") String orderId,
            @RequestParam("processId") Long processId){
        ActivitiVo params = new ActivitiVo();
        params.setCustomerId(customerId);
        params.setOrderId(orderId);
        params.setProcessId(processId);
        params.setUserId("123");
        params.setUserName("1000000");
        return activitiService.startProcess(params);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable thread:" + Thread.currentThread().getId());
            }
        };
        System.out.println("main thread:" + Thread.currentThread().getId());
        runnable.run();
    }
}

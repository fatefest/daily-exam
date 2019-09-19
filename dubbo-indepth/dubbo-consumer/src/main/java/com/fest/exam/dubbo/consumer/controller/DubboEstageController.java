//package com.fest.exam.dubbo.consumer.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSONObject;
//import com.yunche.framework.result.ResultBean;
//import com.yunche.inparts.service.InpartsEstageCallbackService;
//import io.swagger.annotations.Api;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @Author: yesitao
// * @Date: 2019/5/27 15:29
// * @Description:
// */
//@RestController
//@RequestMapping("/estage")
//@Api(tags = "123")
//public class DubboEstageController {
//
//    @Reference(version = "1.0.0")
//    private InpartsEstageCallbackService inpartsEstageCallbackService;
//
//    @PostMapping("/back")
//    public ResultBean findPartnerDealerById(@RequestBody JSONObject query) throws Exception {
//        inpartsEstageCallbackService.callback(query);
//        return ResultBean.ofSuccess();
//    }
//
//}

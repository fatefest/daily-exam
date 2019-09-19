package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yunche.config.service.DubboProductProcessService;
import com.yunche.framework.result.ResultBean;
import com.yunche.pojo.vo.ProductProcessVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yesitao
 * @Date: 2019/9/5 15:39
 * @Description: common
 */
@RestController
@RequestMapping("/common")
@Api(tags = "配置中心公用")
public class DubboCommonController {
    @Reference
    private DubboProductProcessService dubboProductProcessService;

    @GetMapping("/production")
    public ResultBean findPartnerDealerById(@RequestParam String productId) throws Exception {
        ProductProcessVO productProcessVO = dubboProductProcessService.getProductProcessVOById(productId);
        return ResultBean.ofSuccess(productProcessVO);
    }
}

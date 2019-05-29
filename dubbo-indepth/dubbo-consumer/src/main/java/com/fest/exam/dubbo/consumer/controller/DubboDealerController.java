package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fest.exam.dubbo.consumer.domain.TeamDealerQuery;
import com.yunche.framework.result.ResultBean;
import com.yunche.user.entity.TbDealer;
import com.yunche.user.service.DubboDealerService;
import com.yunche.user.vo.DealerAssociationDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yesitao
 * @Date: 2019/5/27 15:29
 * @Description:
 */
@RestController
@RequestMapping("/dealer")
@Api(tags = "车商")
public class DubboDealerController {
    @Reference
    DubboDealerService dubboDealerService;

    @PostMapping("/dealers")
    public ResultBean findPartnerDealerById(@RequestBody TeamDealerQuery query) throws Exception {
        return ResultBean.ofSuccess(dubboDealerService.getDealerListByPartnerId(
                query.getCurrentPage(),
                query.getPageSize(),
                query.getName(),
                query.getHeadName(),
                query.getPartnerId(),
                query.getStatus())
        );
    }

    @GetMapping("/info/{id}")
    public ResultBean findPartnerDealerById(@PathVariable("id") String id) throws Exception {
        return ResultBean.ofSuccess(dubboDealerService.findDealerById(id));
    }

    @PostMapping("/add")
    public ResultBean addDealer(@RequestBody DealerAssociationDTO entity) throws Exception {
//        dubboDealerService.addDealer(entity);
        return ResultBean.ofSuccess();
    }

    @PostMapping("/update")
    public ResultBean updateDealer(@RequestBody TbDealer entity) throws Exception {
//        dubboDealerService.updateDealer(entity);
        return ResultBean.ofSuccess();
    }

}

package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yunche.config.service.DubboDataFlowService;
import com.yunche.customer.entity.CustomerBankCreditRecord;
import com.yunche.external.service.BankCreditRecordService;
import com.yunche.framework.result.ResultBean;
import com.yunche.user.entity.TbDealer;
import com.yunche.user.service.DubboDealerService;
import com.yunche.user.vo.DealerAcoountVO;
import com.yunche.user.vo.DealerAllVO;
import com.yunche.user.vo.DealerCostParameter;
import com.yunche.user.vo.DealerPage;
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
    @Reference
    BankCreditRecordService bankCreditRecordService;
    @Reference
    DubboDataFlowService dubboDataFlowService;

    @PostMapping("/dealers")
    public ResultBean findPartnerDealerById(@RequestBody DealerPage query) throws Exception {
        return ResultBean.ofSuccess(dubboDealerService.getDealerListByPartnerId(query));
    }

    @GetMapping("/info/{partnerId}/{id}")
    public ResultBean findPartnerDealerById(@PathVariable("id") String id,
                                            @PathVariable("partnerId") String partnerId) throws Exception {
        return ResultBean.ofSuccess(dubboDealerService.queryDealerAllVOByDealerId(id,partnerId));
    }

    @PostMapping("/add")
    public ResultBean addDealer(@RequestBody DealerAllVO entity) throws Exception {
        dubboDealerService.addDealerAllVO(entity);
        return ResultBean.ofSuccess();
    }

    @PostMapping("/update")
    public ResultBean updateDealer(@RequestBody TbDealer entity) throws Exception {
        dubboDealerService.updateDealer(entity);
        return ResultBean.ofSuccess();
    }

    @PostMapping("/account")
    public ResultBean addAccount(@RequestBody DealerAcoountVO dealerAcoountVO){
        dubboDealerService.addAccount(dealerAcoountVO);
        return ResultBean.ofSuccess();
    }

    @GetMapping("/bankCredit/{idCard}")
    public ResultBean getBankCredit(@PathVariable("idCard") String id){
        CustomerBankCreditRecord customerBankCreditRecord = bankCreditRecordService.getByIdCard(id);
        return ResultBean.ofSuccess(customerBankCreditRecord);
    }

    @GetMapping("/materialFlow/{productionId}")
    public ResultBean getMaterialFlowTask(@PathVariable("productionId") String productionId) throws Exception {
        return ResultBean.ofSuccess(dubboDataFlowService.getTbDataFlowDetailByProductId(productionId));
    }

    @GetMapping("/test")
    public ResultBean test() throws Exception {
        return ResultBean.ofSuccess("tttttt");
    }

    @GetMapping("/cost")
    public ResultBean cost(String dealerId,String partnerId,Integer carType,Integer loanPeriod) throws Exception {
        DealerCostParameter queryParam = new DealerCostParameter();
        queryParam.setDealerId(dealerId);
        queryParam.setPartnerId(partnerId);
        queryParam.setCarType(carType);
        queryParam.setLoanTime(loanPeriod);
        queryParam.setBusinessArea(1);
        return ResultBean.ofSuccess(dubboDealerService.queryDealerCostList(queryParam));
    }



}

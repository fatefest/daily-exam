package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yunche.config.service.DubboPartnerCheckService;
import com.yunche.exception.PartnerExistException;
import com.yunche.framework.enums.CheckTyleEnum;
import com.yunche.pojo.vo.PartnerReviewVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yesitao
 * @Date: 2019/4/30 14:24
 * @Description: 配置审核级别接口
 */
@RestController
@RequestMapping("/partner")
public class DubboPartnerCheckController {

    @Reference
    private DubboPartnerCheckService dubboPartnerCheckService;

    /**
     * 审核配置获取
     *
     * @param partnerId 合伙人ID
     * @return
     */
    @GetMapping("/partnerCheck/{partnerId}")
    public List<PartnerReviewVo> findPartnerCheckByPartnerById(@PathVariable("partnerId") String partnerId)
            throws NullPointerException, PartnerExistException{
        return dubboPartnerCheckService.findPartnerCheckByPartnerById(partnerId);
    }


    /**
     * 获取合伙人征信审核
     *
     * @param partnerId
     * @return
     */
    @GetMapping("/partnerCheck/{type}/{partnerId}")
    public PartnerReviewVo findPartnerCheck(@PathVariable("partnerId") String partnerId,
                                            @PathVariable("type")CheckTyleEnum checkTyleEnum)
            throws NullPointerException, PartnerExistException{
        PartnerReviewVo vo = dubboPartnerCheckService.findPartnerCheck(partnerId,checkTyleEnum);
        return vo;
    }


    /**
     * 通过合伙人   员工   审核类型  审核级别  查询员工是否在审核级别里面
     *
     * @param partner       合伙人
     * @param userId        员工ID
     * @param checkTyleEnum 审核类型
     * @param level         级别
     * @return
     */
    @GetMapping("/checkLevel")
   public Boolean findEmployeeIsCheckType(
            @RequestParam("partner") String partner,
            @RequestParam("userId") String userId,
            @RequestParam("type") CheckTyleEnum checkTyleEnum,
            @RequestParam("level") Integer level)
           throws NullPointerException, PartnerExistException{
       return dubboPartnerCheckService.findEmployeeIsCheckType(partner,userId,checkTyleEnum,level);
   }


    /**
     * 根据 合伙人   员工ID    审核类型  获取他对应的审核级别
     *
     * @param partner
     * @param userId
     * @param checkTyleEnum
     * @return
     */
    @GetMapping("/employeeLevel")
    public Integer findEmployeeLevel(
            @RequestParam("partnerId") String partner,
            @RequestParam("userId") String userId,
            @RequestParam("type") CheckTyleEnum checkTyleEnum)
            throws NullPointerException, PartnerExistException{
        return dubboPartnerCheckService.findEmployeeLevel(partner,userId,checkTyleEnum);
    }


}

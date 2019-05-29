package com.fest.exam.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fest.exam.dubbo.consumer.domain.TeamRoleQuery;
import com.fest.exam.dubbo.consumer.domain.TeamUserQuery;
import com.yunche.framework.result.ResultBean;
import com.yunche.user.entity.TbSysOrg;
import com.yunche.user.entity.TbSysRole;
import com.yunche.user.entity.TbSysUser;
import com.yunche.user.service.*;
import com.yunche.user.vo.SysOrgVO;
import com.yunche.user.vo.SysPermissionVO;
import com.yunche.user.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yesitao
 * @Date: 2019/5/27 15:29
 * @Description:
 */
@RestController
@RequestMapping("/team")
@Api(tags = "团队管理")
public class DubboTeamController {
    @Reference
    DubboSysRoleService dubboSysRoleService;
    @Reference
    DubboSysUserService dubboSysUserService;
    @Reference
    DubboSysOrgService dubboSysOrgService;
    @Reference
    DubboPartnerCheckService dubboPartnerCheckService;
    @Reference
    DubboSysPermissionService dubboSysPermissionService;


    @ApiOperation(value = "查询角色列表")
    @PostMapping("/roles")
    public ResultBean getRoles(@RequestBody TeamRoleQuery teamRoleQuery) throws Exception {
        return ResultBean.ofSuccess(dubboSysRoleService.getRoleList(teamRoleQuery,
                teamRoleQuery.getCurrentPage(),
                teamRoleQuery.getPageSize()));
    }

    @ApiOperation(value = "获取合伙人的组织")
    @GetMapping("/{partnerId}/org")
    public ResultBean getPartnerOrg(@PathVariable("partnerId") String id) throws Exception {
        SysOrgVO query = new SysOrgVO();
        query.setPartnerId(id);
        return ResultBean.ofSuccess(dubboSysOrgService.getPartnerFirstOrgList(query));
    }

    @ApiOperation(value = "获取id的下级组织信息")
    @GetMapping("/org/{id}/next")
    public ResultBean getNextOrg(@PathVariable("id") Integer id) throws Exception {
        return ResultBean.ofSuccess(dubboSysOrgService.getNextOrgListById(id));
    }

    @ApiOperation(value = "添加合伙人组织")
    @PostMapping("/org")
    public ResultBean addOrg(@RequestBody TbSysOrg org) throws Exception {
        dubboSysOrgService.addPartnerOrg(org);
        return ResultBean.ofSuccess();
    }

    @ApiOperation(value = "修改合伙人组织")
    @PutMapping("/org")
    public ResultBean updateOrg(@RequestBody TbSysOrg org) throws Exception {
        dubboSysOrgService.updatePartnerOrg(org);
        return ResultBean.ofSuccess();
    }

    @ApiOperation(value = "停用启用组织")
    @PutMapping("/org/switch")
    public ResultBean openOrCloseOrg(@RequestBody TbSysOrg org) throws Exception {
        dubboSysOrgService.updateEnable(org);
        return ResultBean.ofSuccess();
    }

    @ApiOperation(value = "获取合伙人的员工列表")
    @PostMapping("/users")
    public ResultBean getUsers(@RequestBody TeamUserQuery teamUserQuery) throws Exception {
        return ResultBean.ofSuccess(dubboSysUserService.getPartnerUserList(teamUserQuery,
                teamUserQuery.getCurrentPage(),
                teamUserQuery.getPageSize()));
    }

    @ApiOperation(value = "根据id查询员工详情")
    @GetMapping("/user/{id}")
    public ResultBean getUserById(@PathVariable("id") String id){
        return ResultBean.ofSuccess(dubboSysUserService.getUserById(id));
    }

    @ApiOperation(value = "根据id查询员工详情")
    @PostMapping("/user")
    public ResultBean saveUser(@RequestBody TbSysUser entity){
        dubboSysUserService.addPartnerUser(entity);
        return ResultBean.ofSuccess();
    }

    @ApiOperation(value = "合伙人配置的审核列表")
    @GetMapping("/checks/{partnerId}")
    public ResultBean getPartnerChecks(@PathVariable("partnerId") String partnerId){
        return ResultBean.ofSuccess(dubboPartnerCheckService.findPartnerCheckByPartnerById(partnerId));
    }

    @ApiOperation(value = "获取权限列表")
    @GetMapping("/permission/{partnerId}")
    public ResultBean getPermissions(@PathVariable("partnerId") String partnerId) throws Exception {
        SysPermissionVO sysPermissionVO = new SysPermissionVO();
        sysPermissionVO.setStatus(1);
        return ResultBean.ofSuccess(dubboSysPermissionService.getPartnerPermissionList(sysPermissionVO,1,1000));
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public ResultBean addRole(@RequestBody TbSysRole tbSysRole) throws Exception {
        dubboSysRoleService.addPartnerRole(tbSysRole);
        return ResultBean.ofSuccess();
    }

}

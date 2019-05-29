package com.fest.exam.dubbo.consumer.domain;

import com.yunche.user.vo.SysRoleVO;
import lombok.Data;

/**
 * @Author: yesitao
 * @Date: 2019/5/28 9:54
 * @Description:
 */
@Data
public class TeamRoleQuery extends SysRoleVO  {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}

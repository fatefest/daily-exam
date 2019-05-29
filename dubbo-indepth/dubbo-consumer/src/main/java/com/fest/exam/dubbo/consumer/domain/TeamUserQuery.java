package com.fest.exam.dubbo.consumer.domain;

import com.yunche.user.vo.SysUserVO;
import lombok.Data;

/**
 * @Author: yesitao
 * @Date: 2019/5/28 9:31
 * @Description:
 */
@Data
public class TeamUserQuery extends SysUserVO {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}

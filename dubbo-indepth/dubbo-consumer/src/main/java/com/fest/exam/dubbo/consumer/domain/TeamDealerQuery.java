package com.fest.exam.dubbo.consumer.domain;

import lombok.Data;

/**
 * @Author: yesitao
 * @Date: 2019/5/29 9:42
 * @Description: 车商查询
 */
@Data
public class TeamDealerQuery{
    private String partnerId;
    private String name;
    private String headName;
    private Integer status;
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}

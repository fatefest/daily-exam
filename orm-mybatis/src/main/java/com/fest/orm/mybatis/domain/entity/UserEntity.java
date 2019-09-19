package com.fest.orm.mybatis.domain.entity;

import lombok.Data;

/**
 * @Author: yesitao
 * @Date: 2019/9/11 16:39
 * @Description: 用户
 */
@Data
public class UserEntity {
    private String name;
    private Integer id;
    private String email;
    private Integer age;
    private Integer version;
}

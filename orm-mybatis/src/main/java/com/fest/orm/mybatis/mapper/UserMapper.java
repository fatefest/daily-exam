package com.fest.orm.mybatis.mapper;

import com.fest.orm.mybatis.domain.entity.UserEntity;

public interface UserMapper {
    UserEntity selectByUserId(Integer id);
}

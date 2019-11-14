package com.fest.cloud.consumer.nacos.mapper;

import com.fest.cloud.common.domain.entity.CloudUser;

public interface CloudUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CloudUser record);

    int insertSelective(CloudUser record);

    CloudUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloudUser record);

    int updateByPrimaryKey(CloudUser record);
}
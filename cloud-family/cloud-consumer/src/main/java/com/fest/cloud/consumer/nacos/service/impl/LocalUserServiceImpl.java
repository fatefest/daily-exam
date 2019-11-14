package com.fest.cloud.consumer.nacos.service.impl;

import com.fest.cloud.common.domain.entity.CloudUser;
import com.fest.cloud.consumer.nacos.mapper.CloudUserMapper;
import com.fest.cloud.consumer.nacos.service.LocalUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yesitao
 * @Date: 2019/11/14 16:24
 * @Description:
 */
@Service
public class LocalUserServiceImpl implements LocalUserService {

    @Resource
    CloudUserMapper cloudUserMapper;

    @Override
    public void saveUser(CloudUser user) {
        cloudUserMapper.insertSelective(user);
    }
}

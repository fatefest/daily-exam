package com.fest.cloud.consumer.nacos.service;

import com.fest.cloud.common.domain.entity.CloudUser;

/**
 * @Author: yesitao
 * @Date: 2019/11/14 16:23
 * @Description:
 */
public interface LocalUserService {
    void saveUser(CloudUser user);
}

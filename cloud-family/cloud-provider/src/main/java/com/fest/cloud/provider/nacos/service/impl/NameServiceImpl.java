package com.fest.cloud.provider.nacos.service.impl;

import com.fest.cloud.dubbo.service.NameService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: yesitao
 * @Date: 2019/10/31 11:17
 * @Description:
 */
@Service(protocol = {"dubbo"})
public class NameServiceImpl implements NameService {

    @Override
    public String myName() {
        return "fest";
    }
}

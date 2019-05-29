package com.fest.exam.dubbo.service.impl;

import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.fest.exam.dubbo.api.HelloService;

/**
 * @Author: yesitao
 * @Date: 2019/5/13 16:27
 * @Description: wrapper测试
 */
public class WrapperTest {
    public static void main(String[] args) {
        Wrapper wrapper = Wrapper.getWrapper(HelloService.class.getName().indexOf('$') < 0 ? HelloService.class : HelloService.class);
        System.out.println("");
    }
}

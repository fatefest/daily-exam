package com.fest.exam.pattern.facade.subsys;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:28
 * @Description: 引擎
 */
public class Engine implements Work {
    @Override
    public void start() {
        System.out.println("引擎启动");
    }
}

package com.fest.exam.pattern.facade.subsys;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:32
 * @Description: 车灯
 */
public class CarLights implements Work {
    @Override
    public void start() {
        System.out.println("车灯点亮了");
    }
}

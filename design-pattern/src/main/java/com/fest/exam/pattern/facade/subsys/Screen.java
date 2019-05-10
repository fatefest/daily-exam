package com.fest.exam.pattern.facade.subsys;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:29
 * @Description: 显示屏
 */
public class Screen implements Work {
    @Override
    public void start() {
        System.out.println("显示屏开始工作");
    }
}

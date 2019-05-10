package com.fest.exam.pattern.facade.subsys;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:30
 * @Description: 轮胎
 */
public class Tyre implements Work {
    @Override
    public void start() {
        System.out.println("轮胎开始工作");
    }
}

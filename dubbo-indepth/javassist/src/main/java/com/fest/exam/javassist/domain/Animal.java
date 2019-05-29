package com.fest.exam.javassist.domain;

/**
 * @Author: yesitao
 * @Date: 2019/5/10 16:16
 * @Description: 动物
 */
public class Animal {
    private String name;

    public Animal(){
        eat();
    }
    public void eat(){
        System.out.println("吃东西");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package com.fest.exam.javassist.domain;

/**
 * @Author: yesitao
 * @Date: 2019/5/10 16:16
 * @Description: 猴子
 */
public class Monkey extends Animal{

    private String nickName;
    private Food food;


    public Monkey(){
        this.food = new Apple();
    }

    public void climb(){
        System.out.println("climb tree");
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

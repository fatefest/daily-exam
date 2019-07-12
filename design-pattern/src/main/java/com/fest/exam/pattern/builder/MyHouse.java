package com.fest.exam.pattern.builder;

import com.fest.exam.pattern.builder.component.Block;
import com.fest.exam.pattern.builder.component.Host;
import com.fest.exam.pattern.builder.component.Wood;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;

/**
 * @Author: yesitao
 * @Date: 2019/5/16 14:30
 * @Description: a
 */
public class MyHouse {
    private Block block;
    private Wood wood;
    private Host host;

    public MyHouse buildBlock(Block block){
        this.block = block;
        return this;
    }
    public MyHouse buildWood(Wood wood){
        this.wood = wood;
        return this;
    }
    public MyHouse buildHost(Host host){
        this.host = host;
        return this;
    }
    public MyHouse build(){
        return this;
    }

    public static void main(String[] args) {
        Class clz = Collectors.class;
        try {
            Constructor constructor = clz.getDeclaredConstructor();
            //私有构造方法设置成可以访问
            constructor.setAccessible(true);
            Collectors instance = (Collectors) constructor.newInstance();
            System.out.println(instance);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

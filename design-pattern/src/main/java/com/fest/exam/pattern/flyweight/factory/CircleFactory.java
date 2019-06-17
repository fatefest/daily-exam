package com.fest.exam.pattern.flyweight.factory;

import com.fest.exam.pattern.flyweight.draw.Circle;
import com.fest.exam.pattern.flyweight.draw.Shape;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yesitao
 * @Date: 2019/5/15 15:35
 * @Description: 圆工厂
 */
public class CircleFactory {
    /**
     * 将具有通用特点的类使用缓存存储起来，在使用时从工厂中直接拿
     * 拿出来修改赋值特点属性再使用
     * 防止重复创建类似的对象
     */
    private static final Map<String, Shape> circleCache = new ConcurrentHashMap<>();

    public static Shape getCircle(String color){
        Circle circle = (Circle) circleCache.get(color);
        if(circle==null){
            circle = new Circle(color);
            circleCache.put(color,circle);
        }
        return circle;
    }
}

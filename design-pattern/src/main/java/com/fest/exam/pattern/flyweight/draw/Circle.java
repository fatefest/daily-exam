package com.fest.exam.pattern.flyweight.draw;

/**
 * @Author: yesitao
 * @Date: 2019/5/15 15:32
 * @Description: 圆
 */
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("draw a circle color:"+color+" position:{x:"+x+",y:"+y+"} radius:"+radius);
        System.out.println(this.hashCode());
    }
}

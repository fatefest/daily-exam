package com.fest.exam.pattern.flyweight;

import com.fest.exam.pattern.flyweight.draw.Circle;
import com.fest.exam.pattern.flyweight.factory.CircleFactory;

import java.util.EnumSet;
import java.util.Random;

/**
 * @Author: yesitao
 * @Date: 2019/5/15 15:41
 * @Description: 老艺术家
 */
public class OldArtist {
    private static String[] colors = {"red","black","yellow","green","blue","pink","white"};
    private static Random random = new Random();
    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle =
                    (Circle) CircleFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return random.nextInt(100);
    }
    private static int getRandomY() {
        return random.nextInt(100);
    }
}

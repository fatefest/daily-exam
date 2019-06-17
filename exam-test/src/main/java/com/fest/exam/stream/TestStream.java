package com.fest.exam.stream;


import java.util.*;

import static java.util.Comparator.comparingInt;

/**
 * @Author: yesitao
 * @Date: 2019/5/16 11:14
 * @Description: 1
 */
public class TestStream {
    public static void main(String[] args) {
        Map<Std,String> map = new HashMap<>();
        Std s1 = new Std("alin","18",new ConstantClass());
        Std s2 = new Std("alin","19",new ConstantClass());
        map.put(s1,"aa");
        map.put(s2,"bb");
        map.merge(s1,"cc",(a,b)->a+b);
        Fruit f = Fruit.APPLE;
        System.out.println(map.size());
        System.out.println("s1:"+map.get(s1));
        System.out.println("s2:"+map.get(s2));
        System.out.println(args.getClass().getSuperclass());
        System.out.println(f.sortNum());

        List<String> words = Arrays.asList("abcdefg","efg");
        Collections.sort(words, comparingInt(String::length));
    }

    private enum Fruit{
        APPLE,PEAR,ORANGE;
        public int sortNum(){
            return ordinal();
        }
    }
}

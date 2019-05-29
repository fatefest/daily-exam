package com.fest.exam.stream;


import java.util.HashMap;
import java.util.Map;

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
        System.out.println(map.size());
        System.out.println("s1:"+map.get(s1));
        System.out.println("s2:"+map.get(s2));
    }
}

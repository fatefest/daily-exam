package com.fest.exam.chapter1;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Author: yesitao
 * @Date: 2019/5/15 15:10
 * @Description: main
 */
public class Main {
    public Main(String a,Integer b){}
    public Main(Integer a,String b){}
    public static void main(String[] args) {
        System.out.println(BigInteger.probablePrime(3,new Random()));
    }
}

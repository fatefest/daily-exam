package com.fest.exam.lombok.domain;

import com.fest.exam.annotation.function.Executor;
import com.fest.exam.annotation.function.Testor;

/**
 * @Author: yesitao
 * @Date: 2019/6/15 10:06
 * @Description:
 */
public class TestExecutor implements Executor, Testor {
    @Override
    public int execute(String a, String b) {
        return Integer.parseInt(a)+Integer.valueOf(b);
    }

    @Override
    public void test(String a, Integer b) {
        System.out.println("a is :"+a+" b is :"+b);
    }
}

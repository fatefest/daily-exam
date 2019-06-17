package com.fest.exam.lombok.launch;


import com.fest.exam.lombok.annotation.Getter;
import com.fest.exam.lombok.domain.TestExecutor;

import javax.annotation.processing.Processor;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * @Author: yesitao
 * @Date: 2019/4/25 20:14
 * @Description: 测试主类
 */
@Getter
public class LombokMain {
    private String value;

    private String value2;

    public LombokMain(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ServiceLoader<Processor> serviceLoader = ServiceLoader.load(Processor.class);
        Iterator<Processor> iter = serviceLoader.iterator();
        while(iter.hasNext()){
            Processor p = iter.next();
            System.out.println(p);
        }
    }

}

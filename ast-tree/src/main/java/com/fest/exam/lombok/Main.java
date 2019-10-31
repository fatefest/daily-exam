package com.fest.exam.lombok;

import com.fest.exam.lombok.domain.vo.UserVO;

import javax.annotation.processing.Processor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: yesitao
 * @Date: 2019/10/29 11:01
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader serviceLoader = ServiceLoader.load(Processor.class);
        Iterator it = serviceLoader.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getClass());
        }

        UserVO userVO = new UserVO("alan","33341231");
        try {
            Method m = userVO.getClass().getMethod("getUserName");
            System.out.println(m.invoke(userVO));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("没有方法 getUserName");
        }
    }
}

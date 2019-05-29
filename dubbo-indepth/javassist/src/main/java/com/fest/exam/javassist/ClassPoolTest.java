package com.fest.exam.javassist;

import com.fest.exam.javassist.domain.Animal;
import com.fest.exam.javassist.domain.Banana;
import com.fest.exam.javassist.domain.Food;
import com.fest.exam.javassist.domain.Monkey;
import javassist.ClassPool;
import javassist.CtClass;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: yesitao
 * @Date: 2019/5/10 16:03
 * @Description: 测试
 */
public class ClassPoolTest {
    public static void main(String[] args)  {
//        ClassPool classPool = ClassPool.getDefault();
//        try {
//            CtClass ctClass = classPool.get("com.fest.exam.javassist.domain.Monkey");
//            ctClass.setSuperclass(classPool.get("com.fest.exam.javassist.domain.Animal"));
//            Class c = ctClass.toClass();
//            Method m = c.getMethod("eat",Food.class);
//            Object o = c.newInstance();
//            m.invoke(o, new Banana());
//            Method[] ms = c.getMethods();
//            for(Method mm:ms) {
//                System.out.println(mm.getName()+" args:"+Arrays.asList(mm.getParameterTypes()));
//            }
//            System.out.println(o);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}

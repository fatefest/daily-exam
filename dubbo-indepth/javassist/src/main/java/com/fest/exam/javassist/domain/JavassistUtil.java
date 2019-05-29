package com.fest.exam.javassist.domain;

import javassist.*;

import java.lang.reflect.Method;

/**
 * @Author: yesitao
 * @Date: 2019/5/27 9:52
 * @Description: javassist工具类
 */
public class JavassistUtil {
    private static ClassPool classPool = ClassPool.getDefault();

    public static Class setFather(Class son,Class father) throws NotFoundException, CannotCompileException {
        CtClass ctClass = classPool.get(son.getName());
        ctClass.setSuperclass(classPool.get(father.getName()));
        return ctClass.toClass();
    }

    public static Class addMethod(Class clazz, Method method){
//        Proxy.newProxyInstance()
        return null;
    }
}

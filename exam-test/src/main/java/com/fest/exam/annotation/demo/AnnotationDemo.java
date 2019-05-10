package com.fest.exam.annotation.demo;

import com.fest.exam.annotation.annotation.ExportName;
import com.fest.exam.annotation.domain.PersonIncome;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @Author: yesitao
 * @Date: 2019/4/28 11:50
 * @Description: 注解测试案例
 */
public class AnnotationDemo {

    public static void main(String[] args) {
        PersonIncome personIncome = new PersonIncome();
        personIncome.setName("张三");
        personIncome.setIdCard("2012314231219293");
        personIncome.setYear("2019");
        personIncome.setMonth("3");
        personIncome.setMoney(new BigDecimal("10000.23"));
        personIncome.setPersonalTax(new BigDecimal("435.2"));

        Field[] fields = personIncome.getClass().getDeclaredFields();
        for(Field f:fields){
            ExportName annotation = f.getAnnotation(ExportName.class);
            if(annotation!=null) {
                String exportName = annotation.name();
                String fieldName = f.getName();
                System.out.println(fieldName + " : " + exportName);
            }
        }
    }
}

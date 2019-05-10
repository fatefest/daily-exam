package com.fest.exam.dubbo.service.impl;

import com.fest.exam.dubbo.api.HelloService;
import com.fest.exam.dubbo.domain.Student;

/**
 * @Author: yesitao
 * @Date: 2019/4/29 16:18
 * @Description:
 */
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello! "+name;
    }

    public Student getStudent(String name) {

        Student student = new Student();
        student.setName(name);
        student.setCls(1);
        student.setGrade(6);
        student.setSex(1);
        student.setType("好动型");
        return student;
    }
}

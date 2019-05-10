package com.fest.exam.dubbo.api;

import com.fest.exam.dubbo.domain.Student;

public interface HelloService {
    String sayHello(String name);

    Student getStudent(String name);
}

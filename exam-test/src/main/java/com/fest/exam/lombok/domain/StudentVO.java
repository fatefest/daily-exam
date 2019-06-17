package com.fest.exam.lombok.domain;


import java.util.List;

/**
 * @Author: yesitao
 * @Date: 2019/4/25 20:12
 * @Description: 用户对象
 */
//@Getter
public class StudentVO {


    public StudentVO(String name){
        this.name = name;
    }

    private String name;
    private List<Object> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                '}';
    }
}

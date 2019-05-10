package com.fest.exam.dubbo.domain;

/**
 * @Author: yesitao
 * @Date: 2019/4/29 16:14
 * @Description: 学生类
 */
public class Student extends BaseEntry{

    private String name;
    private Integer grade;
    private Integer cls;
    private String type;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCls() {
        return cls;
    }

    public void setCls(Integer cls) {
        this.cls = cls;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}

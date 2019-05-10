package com.fest.exam.lombok.domain;


import com.fest.exam.lombok.annotation.Getter;

import java.util.List;

/**
 * @Author: yesitao
 * @Date: 2019/4/25 20:12
 * @Description: 用户对象
 */
@Getter
public class StudentVO {

    public StudentVO(String name){
        this.name = name;
    }

    private String name;
    private List<Object> list;
}

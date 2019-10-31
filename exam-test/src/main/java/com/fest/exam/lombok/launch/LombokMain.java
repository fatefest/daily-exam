package com.fest.exam.lombok.launch;


import com.fest.exam.lombok.domain.StudentVO;

/**
 * @Author: yesitao
 * @Date: 2019/4/25 20:14
 * @Description: 测试主类
 */
public class LombokMain {
    private String value;

    private String value2;

    public LombokMain(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        StudentVO studentVO = new StudentVO("张晓明");

    }

}

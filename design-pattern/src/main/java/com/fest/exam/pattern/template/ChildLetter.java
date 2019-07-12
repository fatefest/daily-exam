package com.fest.exam.pattern.template;

import java.util.Date;

/**
 * @Author: yesitao
 * @Date: 2019/6/17 15:06
 * @Description:
 */
public class ChildLetter extends LetterTemplate {
    @Override
    protected void head() {
        System.out.println("我是title");
    }

    @Override
    protected void content() {
        System.out.println("我是正文，给小朋友的一封信");
    }

    @Override
    protected void tail() {
        System.out.println("尾声");
    }

    @Override
    protected void author() {
        System.out.println("作者xxx");
    }

    @Override
    protected void writeDate() {
        System.out.println(new Date());
    }

    @Override
    protected boolean authorHook(){
        return false;
    }

    public static void main(String[] args) {
        ChildLetter c = new ChildLetter();
        c.writeALetter();
    }
}

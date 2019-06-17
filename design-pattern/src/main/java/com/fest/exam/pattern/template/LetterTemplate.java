package com.fest.exam.pattern.template;

/**
 * @Author: yesitao
 * @Date: 2019/6/17 15:01
 * @Description:
 */
public abstract class LetterTemplate {

    /**
     * 思路：使用抽象类定义基本的执行功能，而细节内容使用抽象protected方法让子类去实现
     */
    public final void writeALetter(){
        head();
        content();
        tail();
        if(authorHook()) {
            author();
        }
        writeDate();
    }

    abstract protected void head();

    abstract protected void content();

    abstract protected void tail();

    abstract protected void author();

    abstract protected void writeDate();

    protected boolean authorHook(){
        return true;
    }
}

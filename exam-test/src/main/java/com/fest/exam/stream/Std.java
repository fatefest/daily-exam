package com.fest.exam.stream;


import com.alibaba.fastjson.JSON;

/**
 * @Author: yesitao
 * @Date: 2019/5/20 17:19
 * @Description:
 */
public class Std implements Cloneable{
    private String name;
    private String age;
    private final ConstantClass constantClass;
    public static final String[] a = {"a","b","c"};

    public Std(String name,String age,ConstantClass constantClass){
        this.name = name;
        this.age = age;
        this.constantClass = constantClass;
    }

    @Override
    public boolean equals(Object o){
        Std s = (Std)o;
        if(this.name.equals(s.getName())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(this.age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ConstantClass getConstantClass() {
        return constantClass;
    }

    public static void main(String[] args) {
        ConstantClass c = new ConstantClass();
        c.setA("a1");
        c.setB("b1");
        Std std = new Std("ali","123",c);
//            Std std1 = (Std)std.clone();
        System.out.println(JSON.toJSONString(std));
        c.setB("bb2");
        c.setA("aa2");
        std.a[2]="d";
        System.out.println(JSON.toJSONString(std));
        System.out.println(JSON.toJSONString(std.a));
    }

}

package com.fest.exam.serialize;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;

/**
 * @Author: yesitao
 * @Date: 2019/6/28 11:04
 * @Description:
 */
public class SerializeTest {

    @Test
    public void run1(){
        User u = new User();
        u.setName("dingding");
        u.setAge(15);
        u.setLocation("ZheJiang Hangzhou");
        u.setNation("Han1");
        try {
            FileOutputStream fos = new FileOutputStream("bin.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run2(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("bin.bin");
            ObjectInputStream in = new ObjectInputStream(fis);
            User u = (User) in.readObject();
            System.out.println(JSON.toJSONString(u));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

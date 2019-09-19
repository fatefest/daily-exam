package com.fest.exam.serialize;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @Author: yesitao
 * @Date: 2019/6/28 11:04
 * @Description:
 */
@Data
public class User implements Serializable {
    String name;
    Integer age;
    String location;
    String nation;

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        Runtime.getRuntime().exec("calc");
    }
}

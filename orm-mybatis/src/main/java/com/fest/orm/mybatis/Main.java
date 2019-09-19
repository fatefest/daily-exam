package com.fest.orm.mybatis;

import com.fest.orm.mybatis.domain.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: yesitao
 * @Date: 2019/9/11 16:34
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);


            try(SqlSession session = sqlMapper.openSession()) {
                UserEntity user = session.selectOne("com.fest.orm.mybatis.mapper.UserMapper.selectByUserId", 5);
                if(user!=null) {
                    System.out.println(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

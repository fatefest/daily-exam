package com.fest.exam.lombok.domain.vo;

import com.fest.exam.lombok.annotation.Getter;

/**
 * @Author: yesitao
 * @Date: 2019/10/29 11:01
 * @Description: 呵呵
 */
@Getter
public class UserVO {

    private String userName;
    private String idCard;

    public UserVO(String userName,String idCard){
        this.userName = userName;
        this.idCard = idCard;
    }
}

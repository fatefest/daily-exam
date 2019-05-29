package com.fest.exam.pattern.builder.component;


import lombok.Data;

/**
 * @Author: yesitao
 * @Date: 2019/5/16 14:32
 * @Description: 砖
 */
@Data
public class Block {
    private String blockType;
    private Integer height;
    private Integer width;
    private Integer length;

    public void merge(){
        System.out.println("block start merge to a wall!");
    }
}

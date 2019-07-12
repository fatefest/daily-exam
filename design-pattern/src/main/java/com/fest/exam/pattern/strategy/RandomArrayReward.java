package com.fest.exam.pattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: yesitao
 * @Date: 2019/7/12 15:26
 * @Description:
 */
public class RandomArrayReward implements RewardStrategy {

    private List<Integer> rewardNums;
    private Random random = new Random();

    public RandomArrayReward(){
        rewardNums = new ArrayList<>();
        for(int i=0;i<10;i++){
            rewardNums.add(random.nextInt(100));
        }
    }
    /**
     * 在初始化的随机数里面中奖
     * @param number
     * @return
     */
    @Override
    public boolean isReward(int number) {
        return rewardNums.contains(number);
    }
}

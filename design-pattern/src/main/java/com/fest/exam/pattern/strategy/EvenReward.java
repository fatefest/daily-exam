package com.fest.exam.pattern.strategy;

/**
 * @Author: yesitao
 * @Date: 2019/7/12 14:37
 * @Description:
 */
public class EvenReward implements RewardStrategy {
    /**
     * 偶数中奖
     * @param number
     * @return
     */
    @Override
    public boolean isReward(int number) {
        return number%2==0;
    }
}

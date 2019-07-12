package com.fest.exam.pattern.strategy;

import java.util.Random;

/**
 * @Author: yesitao
 * @Date: 2019/7/12 15:30
 * @Description:
 */
public class RollRewardMain {

    private RewardStrategy strategy;
    private static Random r = new Random();

    public RollRewardMain(RewardStrategy strategy){
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        RollRewardMain rollRewardMain = new RollRewardMain(new RandomArrayReward());
        for(int i=0;i<18;i++) {
            int num = r.nextInt(100);
            System.out.println(num+"号奖励是：" + rollRewardMain.rewardMoney(num));
        }
    }

    public int rewardMoney(int number){
        if(strategy.isReward(number)){
            return 100;
        }else{
            return 0;
        }
    }
}

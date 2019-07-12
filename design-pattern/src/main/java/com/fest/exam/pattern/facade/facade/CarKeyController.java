package com.fest.exam.pattern.facade.facade;

import com.fest.exam.pattern.facade.subsys.*;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:31
 * @Description: 汽车钥匙
 */
public class CarKeyController {
    private Work engine;
    private Work carLights;
    private Work screen;
    private Work tyres;

    public CarKeyController(){
        this.engine = new Engine();
        this.carLights = new CarLights();
        this.screen = new Screen();
        this.tyres = new Tyre();
    }

    /**
     * 门面模式要求一个子系统的外部与其内部的通信必须通过一个统一的门面(Facade)对象进行。
     * 门面模式提供一个高层次的接口，使得子系统更易于使用。
     */
    public void startTheCar(){
        System.out.println("别钥匙，启动车-->");
        engine.start();
        carLights.start();
        screen.start();
        tyres.start();
    }
}

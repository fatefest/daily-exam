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

    public void startTheCar(){
        System.out.println("别钥匙，启动车-->");
        engine.start();
        carLights.start();
        screen.start();
        tyres.start();
    }
}

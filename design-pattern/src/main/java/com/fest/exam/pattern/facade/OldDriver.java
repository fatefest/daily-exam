package com.fest.exam.pattern.facade;

import com.fest.exam.pattern.facade.facade.CarKeyController;

/**
 * @Author: yesitao
 * @Date: 2019/5/9 14:40
 * @Description: 老司机
 */
public class OldDriver {
    private CarKeyController carKeyController;
    public static void main(String[] args) {
        OldDriver oldDriver = new OldDriver();
        oldDriver.setCarKeyController(new CarKeyController());
        oldDriver.getCarKeyController().startTheCar();
    }

    public CarKeyController getCarKeyController() {
        return carKeyController;
    }

    public void setCarKeyController(CarKeyController carKeyController) {
        this.carKeyController = carKeyController;
    }
}

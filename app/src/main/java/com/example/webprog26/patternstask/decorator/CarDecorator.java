package com.example.webprog26.patternstask.decorator;

/**
 * Created by webprog26 on 21.11.17.
 */

public abstract class CarDecorator extends Car{

    public CarDecorator(String carModelTitle) {
        super(carModelTitle);
    }

    public abstract String moveBack();
}

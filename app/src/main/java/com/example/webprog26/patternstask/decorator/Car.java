package com.example.webprog26.patternstask.decorator;

/**
 * Created by webprog26 on 21.11.17.
 */

public abstract class Car implements MoveableCar{

    private final String carModelTitle;

    public Car(String carModelTitle) {
        this.carModelTitle = carModelTitle;
    }

    @Override
    public abstract String moveForward();

    @Override
    public abstract String moveLeft();

    @Override
    public abstract String moveRight();

    protected String getCarModelTitle() {
        return carModelTitle;
    }

    protected String getCarTitle(){
        return getClass().getSimpleName() + " " + getCarModelTitle();
    }
}

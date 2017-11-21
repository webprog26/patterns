package com.example.webprog26.patternstask.decorator;

/**
 * Created by webprog26 on 21.11.17.
 */

public class Kia extends Car {


    public Kia(String carModelTitle) {
        super(carModelTitle);
    }

    @Override
    public String moveForward() {
        return getCarTitle() + MOVES_FORWARD;
    }

    @Override
    public String moveLeft() {
        return getCarTitle() + MOVES_LEFT;
    }

    @Override
    public String moveRight() {
        return getCarTitle() + MOVES_RIGHT;
    }
}

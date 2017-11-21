package com.example.webprog26.patternstask.decorator;

/**
 * Created by webprog26 on 21.11.17.
 */

public class MoveableCarBackDecorator extends CarDecorator {

    private static final String MOVE_BACK = " moves back";

    private final Car car;

    public MoveableCarBackDecorator(String carModelTitle, Car car) {
        super(carModelTitle);
        this.car = car;
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

    @Override
    public String moveBack(){
        return getCarTitle() + MOVE_BACK;
    }

    @Override
    protected String getCarTitle() {
        return car.getCarTitle() + " " + car.getCarModelTitle();
    }
}

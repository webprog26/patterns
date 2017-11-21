package com.example.webprog26.patternstask.decorator;

/**
 * Created by webprog26 on 21.11.17.
 */

public interface MoveableCar {

    String MOVES_FORWARD = " moves forward";
    String MOVES_LEFT = " moves left";
    String MOVES_RIGHT = " moves right";


    String moveForward();
    String moveLeft();
    String moveRight();
}

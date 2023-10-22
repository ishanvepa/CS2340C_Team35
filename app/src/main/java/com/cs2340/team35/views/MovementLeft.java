package com.cs2340.team35.views;

public class MovementLeft implements Movement {
    @Override
    public Integer[] movementStrategy(int x, int y, int screenWidth, int screenHeight) {
        Integer[] newPos = new Integer[] {x, y};
        if (x - 10 >= 0) {
            newPos[0] = x - 10;
        }
        return newPos;
    }
}

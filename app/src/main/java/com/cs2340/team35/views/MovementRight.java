package com.cs2340.team35.views;

public class MovementRight implements Movement {
    @Override
    public Integer[] movementStrategy(int x, int y, int screenWidth, int screenHeight) {
        Integer[] newPos = new Integer[] {x, y};
        if (x + 10 <= screenWidth - 130) {
            newPos[0] = x + 10;
        }
        return newPos;
    }
}

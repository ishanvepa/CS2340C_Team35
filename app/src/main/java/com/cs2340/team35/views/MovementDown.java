package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;

public class MovementDown implements Movement {
    public Integer[] movementStrategy(int x, int y, int screenWidth, int screenHeight) {
        Integer[] newPos = new Integer[] { x, y};
        if (y - 10 >= 0) {
            newPos[1] = y - 10;
        }
        return newPos;
    }
}

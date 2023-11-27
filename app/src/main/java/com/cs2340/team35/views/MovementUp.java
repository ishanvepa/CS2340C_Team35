package com.cs2340.team35.views;

import com.cs2340.team35.models.PlayerModel;

public class MovementUp implements Movement {
    @Override
    public Integer[] movementStrategy(int x, int y, int screenWidth, int screenHeight) {
        Integer[] newPos = new Integer[] {x, y };
        if (y + 10 <= 1797) {
            newPos[1] = y + 10 * PlayerModel.getInstance().getSpeed();
        }
        return newPos;
    }
}

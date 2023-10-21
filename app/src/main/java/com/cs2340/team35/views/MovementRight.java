package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;

public class MovementRight implements Movement {
    public void movementStrategy(PlayerViewModel playerViewModel, int screenWidth, int screenHeight) {
        if (playerViewModel.getX().getValue() + 10 <= screenWidth) {
            playerViewModel.setX(playerViewModel.getX().getValue() + 10);
        }
    }
}

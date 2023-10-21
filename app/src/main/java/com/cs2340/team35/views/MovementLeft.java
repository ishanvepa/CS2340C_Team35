package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;

public class MovementLeft implements Movement {
    @Override
    public void movementStrategy(PlayerViewModel playerViewModel, int screenWidth, int screenHeight) {
        if (playerViewModel.getX().getValue() - 10 >= 0) {
            playerViewModel.setX(playerViewModel.getX().getValue() - 10);
        }
    }
}

package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;

public class MovementDown implements Movement {
    public void movementStrategy(PlayerViewModel playerViewModel, int screenWidth, int screenHeight) {
        if (playerViewModel.getY().getValue() - 10 >= 0) {
            playerViewModel.setY(playerViewModel.getY().getValue() - 10);
        }
}
}

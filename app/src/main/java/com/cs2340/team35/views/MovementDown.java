package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.models.PlayerModel;
public class MovementDown implements Movement {
    public void movementStrategy(PlayerViewModel playerViewModel, int screenWidth, int screenHeight) {
        if (playerViewModel.getY().getValue() - 10 >= 0) {
            playerViewModel.setY(playerViewModel.getY().getValue() - 10);
        }
    }
    public void movementStrategy(PlayerModel playerModel, int screenWidth, int screenHeight) {
        if (playerModel.getY() - 10 >= 0) {
            playerModel.setY(playerModel.getY() - 10);
        }
    }
}

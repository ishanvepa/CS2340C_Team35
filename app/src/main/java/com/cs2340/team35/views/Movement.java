package com.cs2340.team35.views;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;

public interface Movement {
     public void movementStrategy(PlayerViewModel playerViewModel, int screenWidth, int screenHeight);
     public void movementStrategy(PlayerModel playerModel, int screenWidth, int screenHeight);
}

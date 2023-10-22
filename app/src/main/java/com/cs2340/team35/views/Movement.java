package com.cs2340.team35.views;

import com.cs2340.team35.viewmodels.PlayerViewModel;

public interface Movement {
     public Integer[] movementStrategy(int x, int y, int screenWidth, int screenHeight);
}

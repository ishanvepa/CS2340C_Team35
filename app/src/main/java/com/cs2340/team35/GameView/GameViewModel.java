package com.cs2340.team35.GameView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private final MutableLiveData<GameState> gameState = new MutableLiveData<>(new GameState(0, 0));
}

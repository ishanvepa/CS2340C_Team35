package com.cs2340.team35.GameView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private final MutableLiveData<GameState> gameState = new MutableLiveData<>(new GameState(100, 100));

    public LiveData<GameState> getGameState() {
        return gameState;
    }
}

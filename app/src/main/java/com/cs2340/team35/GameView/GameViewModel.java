package com.cs2340.team35.GameView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private final MutableLiveData<GameState> gameState = new MutableLiveData<>(new GameState(GameState.Difficulty.EASY, GameState.CharacterName.MARIO, 0, 0, "Mario"));

    public LiveData<GameState> getGameState() {
        return gameState;
    }

    public void SetState(GameState newState) {
        gameState.setValue(newState);
    }

}

package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cs2340.team35.models.GameModel;

public class GameViewModel extends ViewModel {

    public String getDifficulty() {
        GameModel instance = GameModel.getInstance();
        return instance.getGameDifficulty().toString();
    }

    public void setDifficulty(GameModel.Difficulty diff) {
        GameModel instance = GameModel.getInstance();
        instance.setGameDifficulty(diff);
    }
}

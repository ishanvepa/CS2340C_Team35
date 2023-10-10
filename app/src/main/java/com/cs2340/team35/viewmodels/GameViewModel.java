package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cs2340.team35.models.GameModel;

public class GameViewModel extends ViewModel {

    private MutableLiveData<Integer> timeElapsed;

    public String getDifficulty() {
        GameModel instance = GameModel.getInstance();
        return instance.getGameDifficulty().toString();
    }

    public void setDifficulty(String diff) {
        GameModel instance = GameModel.getInstance();
        instance.setGameDifficulty(GameModel.Difficulty.valueOf(diff));
    }

    public int getLevel() {
        GameModel instance = GameModel.getInstance();
        return instance.getLevel();
    }

    public void increaseLevel() {
        GameModel instance = GameModel.getInstance();
        instance.setLevel(instance.getLevel() + 1);
    }

    public void resetLevel() {
        GameModel instance = GameModel.getInstance();
        instance.setLevel(1);
    }

    public GameViewModel() {
        this.timeElapsed = new MutableLiveData<>(0);
    }

    public LiveData<Integer> getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Integer timeElapsed) {
        this.timeElapsed.postValue(timeElapsed);
    }
}

package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.WallModel;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<WallModel> getWalls() {
        GameModel instance = GameModel.getInstance();
        return instance.getWalls();
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
        GameModel instance = GameModel.getInstance();
        this.timeElapsed = new MutableLiveData<>(instance.getTimeElapsed());
    }

    public LiveData<Integer> getTimeElapsed() {
        return timeElapsed;
    }

    public void incrementTimeElapsed() {
        GameModel instance = GameModel.getInstance();
        instance.setTimeElapsed(instance.getTimeElapsed() + 1);
        this.timeElapsed.postValue(instance.getTimeElapsed());
    }

    public void resetTimeElapsed() {
        GameModel instance = GameModel.getInstance();
        instance.setTimeElapsed(0);
        this.timeElapsed.postValue(instance.getTimeElapsed());
    }

    public boolean isCollision(int x, int y) {
        GameModel instance = GameModel.getInstance();
        List<WallModel> walls = instance.getWalls();
        for (WallModel wall : walls) {
            if (x > wall.getLeftMargin() && x < wall.getLeftMargin() + wall.getWidth()
                    && ((y > wall.getTopMargin() && y < wall.getTopMargin() + wall.getHeight())
                    || (y + 120 > wall.getTopMargin() && y + 120
                    < wall.getTopMargin() + wall.getHeight()))) {
                return true; // Collision detected
            }
        }
        return false; // No collision
    }
}

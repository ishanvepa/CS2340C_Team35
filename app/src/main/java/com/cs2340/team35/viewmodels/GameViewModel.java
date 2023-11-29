package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.PowerupInterface;
import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.models.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class GameViewModel extends ViewModel implements PlayerModel.Subscriber {

    private MutableLiveData<Integer> timeElapsed;
    private MutableLiveData<ArrayList<Enemy>> enemyArraylist;
    private MutableLiveData<ArrayList<PowerupInterface>> powerupArraylist;

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
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemyArraylist.setValue(enemies);
    }

    public LiveData<ArrayList<Enemy>> getEnemies() {
        GameModel instance = GameModel.getInstance();
        if (enemyArraylist == null || enemyArraylist.getValue() == null) {
            enemyArraylist = new MutableLiveData<>(instance.getEnemies());
        }
        return enemyArraylist;
    }

    public LiveData<ArrayList<PowerupInterface>> getPowerups() {
        GameModel instance = GameModel.getInstance();
        if (powerupArraylist == null || powerupArraylist.getValue() == null) {
            powerupArraylist = new MutableLiveData<>(instance.getPowerups());
        }
        return powerupArraylist;
    }


    public int getLevel() {
        GameModel instance = GameModel.getInstance();
        return instance.getLevel();
    }

    public void increaseLevel() {
        GameModel instance = GameModel.getInstance();
        instance.setLevel(instance.getLevel() + 1);
        enemyArraylist = new MutableLiveData<>(instance.getEnemies());
    }

    public void resetLevel() {
        GameModel instance = GameModel.getInstance();
        instance.setLevel(1);
    }

    public GameViewModel() {
        GameModel instance = GameModel.getInstance();
        PlayerModel pInstance = PlayerModel.getInstance();
        this.timeElapsed = new MutableLiveData<>(instance.getTimeElapsed());
        pInstance.addSubscriber(this);
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

    public void enemyTimestep() {
        GameModel instance = GameModel.getInstance();
        instance.enemyTimestep();
        this.enemyArraylist.postValue(instance.getEnemies());
    }

    public boolean isCollision(int x, int y, int width, int height) {
        GameModel instance = GameModel.getInstance();
        return instance.isCollision(x, y, width, height);
    }

    @Override
    public void positionUpdated(int xpos, int ypos) {

    }

    @Override
    public void powerupUpdated() {
        getPowerups();
        GameModel instance = GameModel.getInstance();
        this.powerupArraylist.postValue(instance.getPowerups());
    }
}

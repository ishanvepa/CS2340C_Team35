package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;

public class PlayerViewModel extends ViewModel {

    private MutableLiveData<Integer> x;
    private MutableLiveData<Integer> y;
    private MutableLiveData<Integer> health;
    private MutableLiveData<ScoreModel> score;

    public PlayerViewModel() {
        PlayerModel instance = PlayerModel.getInstance();
        this.x = new MutableLiveData<>(instance.getX());
        this.y = new MutableLiveData<>(instance.getY());
        this.health = new MutableLiveData<>(instance.getHealth());
        this.score = new MutableLiveData<>(instance.getScore());
    }

    public String getCharacterName() {
        PlayerModel instance = PlayerModel.getInstance();
        return instance.getCharacter().toString();
    }

    public void setCharacterName(String name) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setCharacter(PlayerModel.CharacterName.valueOf(name));
    }

    public String getUserName() {
        PlayerModel instance = PlayerModel.getInstance();
        return instance.getUserName();
    }

    public void setUserName(String name) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setUserName(name);
    }

    public LiveData<Integer> getX() {
        return x;
    }

    public LiveData<Integer> getY() {
        return y;
    }
    public void setX(Integer xpos) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setX(xpos);
        x.setValue(instance.getX());
    }

    public void setY(Integer ypos) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setY(ypos);
        y.setValue(instance.getY());
    }
    public LiveData<Integer> getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setHealth(health);
        this.health.postValue(instance.getHealth());
    }

    public LiveData<ScoreModel> getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setScore(score);
        this.score.postValue(instance.getScore());
    }
}

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

    public LiveData<Integer> getX() {
        return x;
    }

    public LiveData<Integer> getY() {
        return y;
    }

    public LiveData<Integer> getHealth() {
        return health;
    }

    public LiveData<ScoreModel> getScore() {
        return score;
    }

    public void setScore(int score) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setScore(score);
    }
}

package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;

public class PlayerViewModel extends ViewModel implements PlayerModel.Subscriber {

    private MutableLiveData<Integer[]> position;
    private MutableLiveData<Integer> health;
    private MutableLiveData<ScoreModel> score;

    public PlayerViewModel() {
        PlayerModel instance = PlayerModel.getInstance();
        this.position = new MutableLiveData<>(new Integer[] {instance.getX(), instance.getY() });
        this.health = new MutableLiveData<>(instance.getHealth());
        this.score = new MutableLiveData<>(instance.getScore());
        instance.addSubscriber(this);
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

    public LiveData<Integer[]> getPosition() {
        return position;
    }
    public void setPosition(Integer xpos, Integer ypos) {
        PlayerModel instance = PlayerModel.getInstance();
        instance.setPosition(xpos, ypos);
    }

    public void positionUpdated(int xpos, int ypos) {
        this.position.setValue(new Integer[] {xpos, ypos});
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

    public static PlayerModel getInstance() {
        return PlayerModel.getInstance();
    }

}

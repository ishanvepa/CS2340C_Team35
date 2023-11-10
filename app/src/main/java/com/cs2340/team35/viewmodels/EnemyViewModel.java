package com.cs2340.team35.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cs2340.team35.models.EnemyModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;

public class EnemyViewModel {
    private MutableLiveData<Integer[]> position;
    private MutableLiveData<Integer> health;
    private EnemyModel instance;
    public EnemyViewModel(EnemyModel instance) {
        this.instance = instance;
        this.position = new MutableLiveData<>(new Integer[] {instance.getX(), instance.getY() });
        this.health = new MutableLiveData<>(instance.getHealth());
    }

    public String getCharacterName() {
        PlayerModel instance = PlayerModel.getInstance();
        return instance.getCharacter().toString();
    }



    public LiveData<Integer[]> getPosition() {
        return position;
    }
    public void setPosition(Integer xpos, Integer ypos) {
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






}

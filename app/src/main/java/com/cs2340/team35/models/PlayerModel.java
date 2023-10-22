package com.cs2340.team35.models;

import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel {
    private static PlayerModel instance;
    private static int x;
    private static int y;

    private static ScoreModel score;

    private static int health;
    public enum CharacterName { MARIO, LUIGI, PEACH }
    private static CharacterName character;
    private static String userName;

    public interface Subscriber {
        public void positionUpdated(int newX, int newY);
    }

    public List<Subscriber> subscriberList;

    public void addSubscriber(Subscriber s) {
        subscriberList.add(s);
    }

    private PlayerModel() {
        x = 100;
        y = 600;
        character = CharacterName.MARIO;
        userName = "";
        health = 0;
        score = new ScoreModel(10);
        subscriberList = new ArrayList<>();
    }

    public static PlayerModel getInstance() {
        if (instance == null) {
            instance = new PlayerModel();
        }
        return instance;
    }

    public void setX(int newX) {
        if (newX < 0) {
            newX = 0;
        }
        x = newX;
    }

    public void setY(int newY) {
        if (newY < 0) {
            newY = 0;
        }

        y = newY;
    }

    public void setPosition(int newX, int newY) {
        if (newX < 0) {
            newX = 0;
        }
        x = newX;

        if (newY < 0) {
            newY = 0;
        }
        y = newY;
        for (Subscriber s : subscriberList) {
            s.positionUpdated(newX, newY);
        }
    }

    public void setCharacter(CharacterName character) {
        PlayerModel.character = character;
    }

    public static CharacterName getCharacter() {
        return character;
    }

    public void setUserName(String userName) {
        PlayerModel.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ScoreModel getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
}

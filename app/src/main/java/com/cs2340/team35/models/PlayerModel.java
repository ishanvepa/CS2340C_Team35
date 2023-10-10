package com.cs2340.team35.models;

import com.cs2340.team35.viewmodels.GameState;

public class PlayerModel {
    private static PlayerModel instance;
    private static int x;
    private static int y;

    private static int health;
    public enum CharacterName { MARIO, LUIGI, PEACH }
    private static CharacterName character;
    private static String userName;

    private PlayerModel() {
        this.x = 0;
        this.y = 0;
        this.character = CharacterName.MARIO;
        this.userName = "";
        this.health = 0;
    }
    public PlayerModel getInstance() {
        if (instance == null) {
            instance = new PlayerModel();
        }
        return instance;
    }
    public void setX(int x) {
        PlayerModel.x = x;
    }

    public void setY(int y) {
        PlayerModel.y = y;
    }

    public void setCharacter(CharacterName character) {
        PlayerModel.character = character;
    }

    public void setUserName(String userName) {
        PlayerModel.userName = userName;
    }

}

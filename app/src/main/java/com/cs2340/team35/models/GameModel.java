package com.cs2340.team35.models;

public class GameModel {
    public enum Difficulty { EASY, MEDIUM, HARD }
    private static Difficulty GameDifficulty;
    private static GameModel instance;
    private GameModel() {
        GameDifficulty = Difficulty.EASY;
    }
    public void setGameDifficulty(Difficulty gameDifficulty) {
        GameDifficulty = gameDifficulty;
    }

    public Difficulty getGameDifficulty() {
        return GameDifficulty;
    }

    public static GameModel getInstance() {
        return instance;
    }


}

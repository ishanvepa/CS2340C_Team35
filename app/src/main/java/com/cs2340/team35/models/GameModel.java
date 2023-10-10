package com.cs2340.team35.models;

public class GameModel {
    public enum Difficulty { EASY, MEDIUM, HARD }
    private static Difficulty GameDifficulty;
    private static GameModel instance;

    private static int level;
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
        if (instance == null) {
            instance = new GameModel();
        }
        return instance;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int newLevel) {
        if (newLevel > 3) {
            newLevel = 3;
        } else if (newLevel < 1) {
            newLevel = 1;
        }
        level = newLevel;
    }
}

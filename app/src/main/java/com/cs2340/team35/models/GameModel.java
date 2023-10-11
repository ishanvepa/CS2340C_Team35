package com.cs2340.team35.models;

public class GameModel {
    public enum Difficulty { EASY, MEDIUM, HARD }
    private static Difficulty gameDifficulty;
    private static GameModel instance;

    private static int level;

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        GameModel.timeElapsed = timeElapsed;
    }

    private static int timeElapsed;
    private GameModel() {
        gameDifficulty = Difficulty.EASY;
    }
    public void setGameDifficulty(Difficulty gameDifficulty) {
        GameModel.gameDifficulty = gameDifficulty;
    }

    public Difficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public static GameModel getInstance() {
        if (instance == null) {
            instance = new GameModel();
        }
        return instance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int newLevel) {
        if (newLevel > 3) {
            newLevel = 3;
        } else if (newLevel < 1) {
            newLevel = 1;
        }
        level = newLevel;
    }
}

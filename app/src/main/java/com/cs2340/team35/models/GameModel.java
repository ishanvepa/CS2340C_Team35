package com.cs2340.team35.models;

import java.util.ArrayList;

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
    private static ArrayList<WallModel> wallModelArrayList;
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
        changeWalls();
    }

    public static boolean isAtExit(int x, int y) {
        if (y + 120 > 1900) {
            return true;
        }

        return false;
    }

    public ArrayList<WallModel> getWalls() {
        return wallModelArrayList;
    }

    private void changeWalls() {
        if (this.getLevel() == 1) {
            this.wallModelArrayList = new ArrayList<>();
            this.wallModelArrayList.add(new WallModel(1080, 42, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 1038, 475));
        } else if (this.getLevel() == 2) {
            this.wallModelArrayList = new ArrayList<>();
            this.wallModelArrayList.add(new WallModel(1080, 42, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 1038, 475));
        } else if (this.getLevel() == 3) {
            this.wallModelArrayList = new ArrayList<>();
            this.wallModelArrayList.add(new WallModel(1080, 42, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 0, 475));
            this.wallModelArrayList.add(new WallModel(42, 950, 1038, 475));
        }
    }
}

package com.cs2340.team35.models;

import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.EnemyFactory;

import java.util.ArrayList;
import java.util.List;

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

    private static ArrayList<Enemy> enemyArrayList;
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
        changeEnemies();
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
    public boolean isCollision(int x, int y) {
        for (WallModel wall : wallModelArrayList) {
            if (x > wall.getLeftMargin() && x < wall.getLeftMargin() + wall.getWidth()
                    && ((y > wall.getTopMargin() && y < wall.getTopMargin() + wall.getHeight())
                    || (y + 120 > wall.getTopMargin() && y + 120
                    < wall.getTopMargin() + wall.getHeight()))) {
                return true; // Collision detected
            }
        }
        return false; // No collision
    }

    public ArrayList<Enemy> getEnemies() {
        return enemyArrayList;
    }

    private void changeEnemies() {
        EnemyFactory booFactory = new BooFactory();

        if (this.getLevel() == 1) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(booFactory.CreateEnemy(10, 10, 1));
        } else if (this.getLevel() == 2) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(booFactory.CreateEnemy(10, 10, 1));
            enemyArrayList.add(booFactory.CreateEnemy(10, 100, 1));
        } else if (this.getLevel() == 3) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(booFactory.CreateEnemy(10, 10, 1));
            enemyArrayList.add(booFactory.CreateEnemy(10, 300, 1));
        }
    }

    public boolean notInBounds(int x, int y) {
        if (y - 10 < 0 || x - 10 < 0 || x + 10 > 1800 - 130 || y + 10 > 1797) {
           return true;
        }

        return false;
    }

    public void enemyTimestep() {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            Enemy enemy = enemyArrayList.get(i);
            int nextX = enemy.getNextPositionX();
            int nextY = enemy.getNextPositionY();

            if (isCollision(nextX, nextY) || notInBounds(nextX, nextX)) {
                enemy.reverseSpeed();
            }

            nextX = enemy.getNextPositionX();
            nextY = enemy.getNextPositionY();

            enemy.setX(nextX);
            enemy.setY(nextY);

            enemyArrayList.set(i, enemy);
        }
    }
}

package com.cs2340.team35.models;

import android.graphics.Rect;

import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.BowserFactory;
import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.EnemyFactory;
import com.cs2340.team35.models.enemies.GoombaFactory;
import com.cs2340.team35.models.enemies.KoopaFactory;

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
        level = 1;
        changeEnemies();
        changeWalls();
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

    public boolean isCollision(int x, int y, int objectWidth, int objectHeight) {
        Rect objectRect = new Rect(x, y, x + objectWidth, y + objectHeight);

        for (WallModel wall : wallModelArrayList) {
            Rect wallRect = new Rect(wall.getLeftMargin(), wall.getTopMargin(),
                    wall.getLeftMargin() + wall.getWidth(),
                    wall.getTopMargin() + wall.getHeight());

            if (Rect.intersects(objectRect, wallRect)) {
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
        EnemyFactory bowserFactory = new BowserFactory();
        EnemyFactory goombaFactory = new GoombaFactory();
        EnemyFactory koopaFactory = new KoopaFactory();

        int damageMultiplier = 1;
        if (this.getGameDifficulty() == Difficulty.MEDIUM) {
            damageMultiplier = 2;
        } else if (this.getGameDifficulty() == Difficulty.HARD) {
            damageMultiplier = 3;
        }

        if (this.getLevel() == 1) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(booFactory.CreateEnemy(80, 500, damageMultiplier, "boo1"));
            enemyArrayList.add(bowserFactory.CreateEnemy(50, 1200, damageMultiplier, "boo4"));
        } else if (this.getLevel() == 2) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(bowserFactory.CreateEnemy(80, 800, damageMultiplier, "boo2"));
            enemyArrayList.add(koopaFactory.CreateEnemy(300, 1200, damageMultiplier, "koopa1"));
        } else if (this.getLevel() == 3) {
            enemyArrayList = new ArrayList<>();
            enemyArrayList.add(booFactory.CreateEnemy(50, 1200, damageMultiplier, "boo4"));
            enemyArrayList.add(bowserFactory.CreateEnemy(200, 1000, damageMultiplier, "bowser1"));
            enemyArrayList.add(goombaFactory.CreateEnemy(900, 600, damageMultiplier, "boo5"));
            enemyArrayList.add(koopaFactory.CreateEnemy(900, 900, damageMultiplier, "koopa1"));
        }

        for (Enemy en : enemyArrayList) {
            en.addCollisisonSubscriber(PlayerModel.getInstance());
        }
    }

    public boolean notInBounds(int x, int y, int width, int height) {
        if (y - 10 < 0 || x - 10 < 0 || x + 10 + width > 1000 || y + 10 + height > 1900) {
           return true;
        }

        return false;
    }

    public void enemyTimestep() {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            Enemy enemy = enemyArrayList.get(i);
            int nextX = enemy.getNextPositionX();
            int nextY = enemy.getNextPositionY();

            if (isCollision(nextX, nextY, enemy.getSizeX(), enemy.getSizeY()) || notInBounds(nextX, nextY, enemy.getSizeX(), enemy.getSizeY())) {
                enemy.reverseSpeed();
            }

            nextX = enemy.getNextPositionX();
            nextY = enemy.getNextPositionY();

            enemy.setX(nextX);
            enemy.setY(nextY);

            enemyArrayList.set(i, enemy);
        }

    }

    //For unit testing
    public ArrayList getEnemyArrayList() {
        return enemyArrayList;
    }
}

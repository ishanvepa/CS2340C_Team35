package com.cs2340.team35.models;
import com.cs2340.team35.views.Enemy;
import com.cs2340.team35.views.EnemyFactory;
import com.cs2340.team35.views.PlayerObserver;

import java.util.Random;
public class EnemyModel implements PlayerObserver {
    private int x;
    private int y;
    private int health;

    private String enemySpecies;

    public void setPosition(Integer xpos, Integer ypos) {
        if (xpos < 0) {
            xpos = 0;
        }
        x = xpos;
        if (ypos < 0) {
            ypos = 0;
        }

        y = ypos;
    }

    public EnemyModel() {
        Random rand = new Random();
        x = rand.nextInt(1797 - 0 + 1) + 0;
        y = rand.nextInt(950 - 0 + 1) + 0;
        int enemyType = rand.nextInt(3 - 0 + 1) + 0;
        if(enemyType == 0) {
            EnemyFactory.createEnemy("Koopa");
            enemySpecies = "Koopa";
        } else if (enemyType == 1) {
            EnemyFactory.createEnemy("Bowser");
            enemySpecies = "Bowser";
        } else if (enemyType == 2) {
            EnemyFactory.createEnemy("Boo");
            enemySpecies = "Boo";
        } else if (enemyType == 3) {
            EnemyFactory.createEnemy("Goomba");
            enemySpecies = "Goomba";
        }

    }
    public EnemyModel(String enemyType) {
        switch (enemyType) {
            case "Koopa":
            EnemyFactory.createEnemy("Koopa");
            enemySpecies = "Koopa";
            break;

            case "Bowser":
            EnemyFactory.createEnemy("Bowser");
            enemySpecies = "Bowser";
            break;

            case "Boo":
            EnemyFactory.createEnemy("Boo");
            enemySpecies = "Boo";
            break;

            case "Goomba":
            EnemyFactory.createEnemy("Goomba");
            enemySpecies = "Goomba";
            break;
        }
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

    @Override
    public void playerUpdatePosition(int playerX, int playerY) {
        x = playerX;
        y = playerY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getEnemySpecies() {
        return enemySpecies;
    }

    public void setEnemySpecies(String enemySpecies) {
        this.enemySpecies = enemySpecies;
    }




}

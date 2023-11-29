package com.cs2340.team35.models;

import com.cs2340.team35.models.enemies.Enemy;

public class Gun {
    private int x;
    private int y;

    public Gun(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void move(int deltaX, int deltaY) {
        this.x = deltaX;
        this.y = deltaY;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void shoot() {
        GameModel game = GameModel.getInstance();
        for(Enemy enemy: game.getEnemies()) {
            if(enemy.getY() + enemy.getSizeX() <= this.x || enemy.getY() - enemy.getSizeY() >= this.x) {
                enemy.setDead(true);
            }
        }
    }
}
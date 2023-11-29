package com.cs2340.team35.models;

import android.graphics.Rect;

import com.cs2340.team35.models.enemies.Enemy;

import java.util.ArrayList;

public class ProjectileModel {
    private int x;
    private int y;

    private int deltaX;

    private int deltaY;

    public final int SIZE_X = 50;
    public final int SIZE_Y = 50;

    public boolean isOffScreen() {
        return offScreen;
    }

    public void setOffScreen(boolean offScreen) {
        this.offScreen = offScreen;
    }

    private boolean offScreen = false;


    public ProjectileModel(int x, int y, int deltaX, int deltaY) {
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void timestep() {
        this.x = this.x + deltaX;
        this.y = this.y + deltaY;
    }

    public void detectCollision() {
        Rect objectRect = new Rect(getX(), getY(), getX() + SIZE_X, getY() + SIZE_Y);

        for (Enemy e : GameModel.getInstance().getEnemies()) {
            if (e.isDead()) {
                continue;
            }

            Rect eR = new Rect(e.getX(), e.getY(), e.getX() + e.getSizeX(), e.getY() + e.getSizeY());
            if (objectRect.intersect(eR)) {
                e.setDead(true);
            }
        }

    };
}

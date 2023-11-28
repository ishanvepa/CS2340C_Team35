package com.cs2340.team35.models;

public class Bullet {
    private static final int SPEED = 10;
    private static final int SIZE = 10;

    private int x;
    private int y;

    public Bullet(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void move() {
        this.x += SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return SIZE;
    }
}

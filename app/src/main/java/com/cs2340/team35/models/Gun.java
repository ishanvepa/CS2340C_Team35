package com.cs2340.team35.models;

public class Gun {
    private int x;
    private int y;

    public Gun(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public Bullet shoot() {
        return new Bullet(x, y);
    }
}
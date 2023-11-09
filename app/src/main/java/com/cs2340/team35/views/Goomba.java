package com.cs2340.team35.views;

public class Goomba extends Enemy {
    public Goomba() {
        setHealth(20);
        setSpeed(10);
    }
    public int attack() {
        return 10;
    }
}

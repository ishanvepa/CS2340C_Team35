package com.cs2340.team35.views;

public class Koopa extends Enemy {
    public Koopa() {
        setHealth(30);
        setSpeed(15);
    }
    public int attack() {
        return 15;
    }
}

package com.cs2340.team35.views;

public class Boo extends Enemy {
    private int health;
    private int speed;
    public Boo() {
        setHealth(50);
        setSpeed(20);
    }
    public int attack() {
        return 20;
    }
}
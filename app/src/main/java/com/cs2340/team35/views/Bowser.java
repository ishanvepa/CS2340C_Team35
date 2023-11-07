package com.cs2340.team35.views;

public class Bowser extends Enemy {
    public Bowser() {
        setHealth(300);
        setSpeed(30);
    }
    public int attack() {
        return 70;
    }
}
package com.cs2340.team35.models;
import java.util.Random;
public class EnemyModel {
    private static int x;
    private static int y;

    public enum EnemyType {KOOPA, BOWSER, BOO, GOOMBA}

    public EnemyModel() {
        Random rand = new Random();
        x = rand.nextInt(1797 - 0 + 1) + 0;
        y = rand.nextInt(950 - 0 + 1) + 0;
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
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

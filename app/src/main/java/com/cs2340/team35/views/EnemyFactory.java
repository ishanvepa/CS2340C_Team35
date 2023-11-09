package com.cs2340.team35.views;

public class EnemyFactory {
    public static Enemy createEnemy(String enemyType) {
        if (enemyType.equals("Goomba")) {
            return new Goomba();
        } else if (enemyType.equals("Boo")) {
            return new Boo();
        } else if (enemyType.equals("Koopa")) {
            return new Koopa();
        } else if (enemyType.equals("Bowser")) {
            return new Bowser();
        }
        return null;
    }
}

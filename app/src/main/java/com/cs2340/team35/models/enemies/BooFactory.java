package com.cs2340.team35.models.enemies;

public class BooFactory extends EnemyFactory {
    @Override
    public Enemy CreateEnemy(int startX, int  startY, int damageMultiplier, String id) {
        return new Boo(startX, startY, damageMultiplier, id);
    }
}

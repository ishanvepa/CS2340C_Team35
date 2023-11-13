package com.cs2340.team35.models.enemies;

public class GoombaFactory extends EnemyFactory {
    @Override
    public Enemy CreateEnemy(int startX, int  startY, int damageMultiplier, String id) {
        return new Goomba(startX, startY, damageMultiplier, id);
    }
}

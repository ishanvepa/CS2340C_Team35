package com.cs2340.team35.models.enemies;

import com.cs2340.team35.models.enemies.Enemy;

public abstract class EnemyFactory {
    public abstract Enemy CreateEnemy(int startX, int  startY, int damageMultiplier);
}

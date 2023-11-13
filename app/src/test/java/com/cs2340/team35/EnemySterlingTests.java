package com.cs2340.team35;

import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.EnemyFactory;
import com.cs2340.team35.models.enemies.Goomba;
import com.cs2340.team35.models.enemies.GoombaFactory;

import org.junit.Assert;
import org.junit.Test;

public class EnemySterlingTests {
    @Test
    public void TestGoombaSpeedReversal() {
        EnemyFactory goombaFactory = new GoombaFactory();
        Enemy goomba = goombaFactory.CreateEnemy(0, 0, 1, "s");
        int y = goomba.getNextPositionY();
        Assert.assertEquals(y, 50);
        goomba.reverseSpeed();
        int y2 = goomba.getNextPositionY();
        Assert.assertEquals(y2, -50);
    }

    @Test
    public void TestChangeDamage() {
        EnemyFactory goombaFactory = new GoombaFactory();
        Enemy goomba = goombaFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(goomba.getDamage(), 5);
        goomba.setDamageMultiplier(5);
        Assert.assertEquals(goomba.getDamage(), 25);
    }
}


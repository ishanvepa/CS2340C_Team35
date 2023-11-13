package com.cs2340.team35;

import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.BowserFactory;
import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.EnemyFactory;
import com.cs2340.team35.models.enemies.GoombaFactory;
import com.cs2340.team35.models.enemies.KoopaFactory;

import org.junit.Assert;
import org.junit.Test;

public class EnemyFactoryTests {
    @Test
    public void TestCorrectDamageValues() {
        EnemyFactory booFactory = new BooFactory();
        EnemyFactory bowserFactory = new BowserFactory();
        EnemyFactory koopaFactory = new KoopaFactory();
        EnemyFactory goombaFactory = new GoombaFactory();

        Enemy boo = booFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(boo.getDamage(), 10);

        Enemy goomba = goombaFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(goomba.getDamage(), 5);

        Enemy koopa = koopaFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(koopa.getDamage(), 15);

        Enemy bowser = bowserFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(bowser.getDamage(), 20);
    }

    @Test
    public void TestDamageMultiplier() {
        EnemyFactory booFactory = new BooFactory();
        EnemyFactory bowserFactory = new BowserFactory();
        EnemyFactory koopaFactory = new KoopaFactory();
        EnemyFactory goombaFactory = new GoombaFactory();

        Enemy boo = booFactory.CreateEnemy(0, 0, 3, "s");
        Assert.assertEquals(boo.getDamage(), 30);

        Enemy goomba = goombaFactory.CreateEnemy(0, 0, 2, "s");
        Assert.assertEquals(goomba.getDamage(), 10);

        Enemy koopa = koopaFactory.CreateEnemy(0, 0, 1, "s");
        Assert.assertEquals(koopa.getDamage(), 15);

        Enemy bowser = bowserFactory.CreateEnemy(0, 0, 4, "s");
        Assert.assertEquals(bowser.getDamage(), 80);
    }
}

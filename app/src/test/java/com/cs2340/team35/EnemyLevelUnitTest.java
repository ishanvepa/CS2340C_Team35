package com.cs2340.team35;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.BowserFactory;
import com.cs2340.team35.models.enemies.Enemy;
import com.cs2340.team35.models.enemies.KoopaFactory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EnemyLevelUnitTest {

    @Test
    public void Level1Test() {
        BooFactory booFactory = new BooFactory();
        BowserFactory bowserFactory = new BowserFactory();
        GameModel testGame = GameModel.getInstance();
        testGame.setLevel(1);
        ArrayList<Enemy> enemy1Arr = GameModel.getInstance().getEnemyArrayList();
        Enemy boo1 = booFactory.CreateEnemy(80, 500, 1, "boo1");
        Enemy bowser1 = bowserFactory.CreateEnemy(50, 1200, 1, "boo4");
        ArrayList<Enemy> enemy1test = new ArrayList<>();
        enemy1test.add(boo1);
        enemy1test.add(bowser1);
        Assert.assertEquals(enemy1Arr.get(0).getDamage(), enemy1test.get(0).getDamage());
        Assert.assertEquals(enemy1Arr.get(0).getX(), enemy1test.get(0).getX());
        Assert.assertEquals(enemy1Arr.get(0).getY(), enemy1test.get(0).getY());
        Assert.assertEquals(enemy1Arr.get(0).getId(), enemy1test.get(0).getId());

        Assert.assertEquals(enemy1Arr.get(1).getDamage(), enemy1test.get(1).getDamage());
        Assert.assertEquals(enemy1Arr.get(1).getX(), enemy1test.get(1).getX());
        Assert.assertEquals(enemy1Arr.get(1).getY(), enemy1test.get(1).getY());
        Assert.assertEquals(enemy1Arr.get(1).getId(), enemy1test.get(1).getId());
    }

    @Test
    public void Level2Test() {
        BowserFactory bowserFactory = new BowserFactory();
        KoopaFactory koopaFactory = new KoopaFactory();
        GameModel testGame = GameModel.getInstance();
        testGame.setGameDifficulty(GameModel.Difficulty.MEDIUM);
        testGame.setLevel(2);
        ArrayList<Enemy> enemy2Arr = GameModel.getInstance().getEnemyArrayList();
        Enemy bowser2 = bowserFactory.CreateEnemy(80, 800, 2, "boo2");
        Enemy koopa2 = koopaFactory.CreateEnemy(300, 1200, 2, "koopa1");
        ArrayList<Enemy> enemy2test = new ArrayList<>();
        enemy2test.add(bowser2);
        enemy2test.add(koopa2);
        Assert.assertEquals(enemy2Arr.get(0).getDamage(), enemy2test.get(0).getDamage());
        Assert.assertEquals(enemy2Arr.get(0).getX(), enemy2test.get(0).getX());
        Assert.assertEquals(enemy2Arr.get(0).getY(), enemy2test.get(0).getY());
        Assert.assertEquals(enemy2Arr.get(0).getId(), enemy2test.get(0).getId());

        Assert.assertEquals(enemy2Arr.get(1).getDamage(), enemy2test.get(1).getDamage());
        Assert.assertEquals(enemy2Arr.get(1).getX(), enemy2test.get(1).getX());
        Assert.assertEquals(enemy2Arr.get(1).getY(), enemy2test.get(1).getY());
        Assert.assertEquals(enemy2Arr.get(1).getId(), enemy2test.get(1).getId());
    }

}

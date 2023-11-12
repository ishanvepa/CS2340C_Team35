package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.Bowser;
import com.cs2340.team35.models.enemies.BowserFactory;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FactoryCollisionTest {
    @Test
    public void BooCollisionOneWallTest() {
        BooFactory booFactory = new BooFactory();
        Boo boo = (Boo) booFactory.CreateEnemy(3, 477, 0, "100");
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(1080, 42, 0, 475)); // top wall
        Assert.assertTrue(WallModel.isCollision(boo.getX(), boo.getY(), walls));


    }
    @Test
    public void BowserCollisionMultipleWallsTest() {
        BowserFactory bowserFactory = new BowserFactory();
        Bowser bowser = (Bowser)
                bowserFactory.CreateEnemy(1038, 480, 0, "100");
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(1080, 42, 0, 475)); // top wall
        walls.add(new WallModel(42, 950, 0, 475)); // left wall
        walls.add(new WallModel(42, 950, 1038, 475)); // right wall
        Assert.assertTrue(WallModel.isCollision(bowser.getX(), bowser.getY(), walls));
    }
}

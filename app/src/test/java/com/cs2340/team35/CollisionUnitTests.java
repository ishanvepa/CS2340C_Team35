package com.cs2340.team35;

import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.views.GameActivity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollisionUnitTests {
    @Test
    public void TestCollisionShouldCollideSingleWalls() {
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(1080, 42, 0, 475)); // top wall
        Assert.assertTrue(WallModel.isCollision(3, 477, walls));
    }

    @Test
    public void TestCollisionShouldCollideMultipleWalls() {
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(1080, 42, 0, 475)); // top wall
        walls.add(new WallModel(42, 950, 0, 475)); // left wall
        walls.add(new WallModel(42, 950, 1038, 475)); // right wall
        Assert.assertTrue(WallModel.isCollision(1038, 480, walls));
    }
}

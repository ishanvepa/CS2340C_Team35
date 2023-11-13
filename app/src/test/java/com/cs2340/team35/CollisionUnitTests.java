package com.cs2340.team35;

import com.cs2340.team35.models.WallModel;

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

    @Test
    public void TestNonCollisionSingleWalls() {
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(480, 21, 5, 275)); //top wall
        Assert.assertFalse(WallModel.isCollision(2, 280, walls));
    }

    @Test
    public void TestNonCollisionMultipleWalls() {
        List<WallModel> walls = new ArrayList<>();
        walls.add(new WallModel(480, 21, 5, 275)); //top wall
        walls.add(new WallModel(21, 400, 5, 275)); //left wall
        walls.add(new WallModel(21, 400, 300, 275)); //right wall
        Assert.assertFalse(WallModel.isCollision(2, 280, walls));
    }

    @Test
    public void TestPlayerHealthAfterCollision() {

    }

}

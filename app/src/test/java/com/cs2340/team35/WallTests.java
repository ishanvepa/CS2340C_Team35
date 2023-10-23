package com.cs2340.team35;
import static org.junit.Assert.assertEquals;
import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.WallModel;
import com.cs2340.team35.viewmodels.PlayerViewModel;
import com.cs2340.team35.views.GameActivity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WallTests {
    @Test
    public void TestWallConfiguration() {
        //create a list of walls
        //test to see if their params are correct using getters


    }

    @Test
    public void TestWallCollisions(){
        //create a wall
        List<WallModel> walls = new ArrayList<>();
        GameActivity ga = new GameActivity();
        walls.add(ga.addWalls(1080, 42, 0, 475)); // top wall
        walls.add(ga.addWalls(42, 950, 0, 475)); // left wall
        walls.add(ga.addWalls(42, 950, 1038, 475)); // right wall
        PlayerViewModel player = new PlayerViewModel();
        player.setPosition(1080, 42);

        assertEquals(true, WallModel.isCollision(1080, 42, walls));
        player.setPosition(0, 0);
        assertEquals(false, WallModel.isCollision(1080, 42, walls));

    }

}

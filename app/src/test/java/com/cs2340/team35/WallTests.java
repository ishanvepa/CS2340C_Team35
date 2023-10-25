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
        GameActivity ga = new GameActivity();
        WallModel wall = new WallModel(1080, 42, 0, 475);

        assertEquals(wall.getHeight(), 42);
        assertEquals(wall.getWidth(), 1080);
        assertEquals(wall.getLeftMargin(), 0);
        assertEquals(wall.getHeight(), 475);



    }

    @Test
    public void TestWallCollisions(){
        List<WallModel> walls = new ArrayList<>();
        GameActivity ga = new GameActivity();
        walls.add(ga.addWalls(1080, 42, 0, 475));
        walls.add(ga.addWalls(42, 950, 0, 475));
        walls.add(ga.addWalls(42, 950, 1038, 475));
        PlayerViewModel player = new PlayerViewModel();
        player.setPosition(1080, 42);

        assertEquals(true, WallModel.isCollision(1080, 42, walls));
        player.setPosition(0, 0);
        assertEquals(false, WallModel.isCollision(1080, 42, walls));

    }

}

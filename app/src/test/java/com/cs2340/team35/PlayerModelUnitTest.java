package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.PlayerModel;

import org.junit.Test;

public class PlayerModelUnitTest {
    @Test
    public void TestPositionBounds() {
        PlayerModel model = PlayerModel.getInstance();
        model.setX(-1);
        assertEquals(0, model.getX());
        model.setX(-1000);
        assertEquals(0, model.getX());

        model.setY(-1);
        assertEquals(0, model.getY());
        model.setY(-1000);
        assertEquals(0, model.getY());
    }
}

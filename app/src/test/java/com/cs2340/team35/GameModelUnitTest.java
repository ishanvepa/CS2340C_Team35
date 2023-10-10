package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.GameModel;

import org.junit.Test;

public class GameModelUnitTest {
    @Test
    public void TestLevelBounds() {
        GameModel model = GameModel.getInstance();
        model.setLevel(0);
        assertEquals(model.getLevel(), 1);
        model.setLevel(4);
        assertEquals(model.getLevel(), 3);

        model.setLevel(-5000);
        assertEquals(model.getLevel(), 1);
        model.setLevel(5000);
        assertEquals(model.getLevel(), 3);
    }
}

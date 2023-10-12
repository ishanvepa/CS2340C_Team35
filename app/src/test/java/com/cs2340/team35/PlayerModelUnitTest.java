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
    @Test
    public void TestEmptyName() {
        PlayerModel model = PlayerModel.getInstance();
        model.setUserName("Mario");
        assertEquals("Mario", model.getUserName());
        model.setUserName("");
        assertEquals("", model.getUserName());
    }

    @Test
    public void TestHealthSetting(){
        PlayerModel pm = PlayerModel.getInstance();
        //test init health
        assertEquals(pm.getHealth(), 0);

        //test EASY difficulty health
        pm.setHealth(150);
        assertEquals(pm.getHealth(), 150);

        //test MEDIUM difficulty health
        pm.setHealth(100);
        assertEquals(pm.getHealth(), 100);

        //test HARD difficulty health
        pm.setHealth(50);
        assertEquals(pm.getHealth(), 50);
    }


}

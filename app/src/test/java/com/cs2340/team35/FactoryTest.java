package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.enemies.Boo;
import com.cs2340.team35.models.enemies.BooFactory;
import com.cs2340.team35.models.enemies.Bowser;
import com.cs2340.team35.models.enemies.BowserFactory;

import org.junit.Test;

public class FactoryTest {
    @Test
    public void BooFactoryTest() {
        BooFactory booFactory = new BooFactory();
        Boo boo = (Boo) booFactory.CreateEnemy(0, 0, 0, "100");
        assertEquals(0, boo.getX());
        assertEquals(0, boo.getY());
        assertEquals(0, boo.getDamageMultiplier());
        assertEquals("100", boo.getId());
    }
    @Test
    public void BowserFactoryTest() {
        BowserFactory bowserFactory = new BowserFactory();
        Bowser bowser = (Bowser)
                bowserFactory.CreateEnemy(0, 0, 0, "100");
        assertEquals(0, bowser.getX());
        assertEquals(0, bowser.getY());
        assertEquals(0, bowser.getDamageMultiplier());
        assertEquals("100", bowser.getId());
    }
}

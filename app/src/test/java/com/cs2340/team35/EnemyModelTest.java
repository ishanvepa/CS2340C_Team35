package com.cs2340.team35;

import static org.junit.Assert.assertEquals;

import com.cs2340.team35.models.EnemyModel;
import com.cs2340.team35.models.WallModel;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EnemyModelTest {
    @Test
    public void EnemyTypeTest() {
        String enemyType1 = "Bowser";
        EnemyModel bowser = new EnemyModel(enemyType1);
        assertEquals(enemyType1, bowser.getEnemySpecies());
        String enemyType2 = "Boo";
        EnemyModel boo = new EnemyModel(enemyType2);
        assertEquals(enemyType2, boo.getEnemySpecies());
        String enemyType3 = "Goomba";
        EnemyModel goomba = new EnemyModel(enemyType3);
        assertEquals(enemyType3, goomba.getEnemySpecies());
        String enemyType4 = "Koopa";
        EnemyModel koopa = new EnemyModel(enemyType4);
        assertEquals(enemyType4, koopa.getEnemySpecies());
    }

    @Test
    public void positionChange() {
        String enemyType1 = "Bowser";
        EnemyModel bowser = new EnemyModel(enemyType1);
        bowser.setPosition(1000, 1000);
        assertEquals(1000, bowser.getX());
        assertEquals(1000, bowser.getY());
    }
}

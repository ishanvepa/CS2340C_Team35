package com.cs2340.team35;

import com.cs2340.team35.models.PowerupBase;
import com.cs2340.team35.models.ScoreModel;

import org.junit.Assert;
import org.junit.Test;

public class RohitFinalTest {
    @Test
    public void correctID() {
        PowerupBase p = new PowerupBase(false, 0, 0, "Socrates", "size");
        Assert.assertEquals("Socrates", p.getId());
    }
    @Test
    public void increaseDecreaseScore() {
        ScoreModel score1 = new ScoreModel(9);
        score1.increaseScore(10);
        Assert.assertEquals(19, score1.getCurrentScore());
        ScoreModel score2 = new ScoreModel(14);
        score2.decreaseScore(7);
        Assert.assertEquals(7, score2.getCurrentScore());
    }
}

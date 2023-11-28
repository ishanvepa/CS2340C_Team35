package com.cs2340.team35;

import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.HealthPowerupDecorator;
import com.cs2340.team35.models.PowerupBase;
import com.cs2340.team35.models.PowerupInterface;

import org.junit.Assert;
import org.junit.Test;

public class PowerupRandomUnitTest {
    @Test
    public void powerUpRandomLevel1() {
        GameModel gameModel = GameModel.getInstance();
        int randomX = gameModel.randomXinScreen(131, 388);
        int randomY = gameModel.randomYinScreen(606, 1769);
        PowerupBase testPowerupBase1 = new PowerupBase(false, randomX, randomY, "health1", "health");
        boolean inRange = false;
        if ((testPowerupBase1.getX() >= 131 && testPowerupBase1.getX() <= 388) && (testPowerupBase1.getY() >= 606 && testPowerupBase1.getY() <= 1769)) {
            inRange = true;
        }
        Assert.assertTrue(inRange);
    }
}

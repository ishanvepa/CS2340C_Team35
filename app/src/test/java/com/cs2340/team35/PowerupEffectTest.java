package com.cs2340.team35;

import com.cs2340.team35.models.HealthPowerupDecorator;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.PowerupBase;
import com.cs2340.team35.models.PowerupInterface;
import com.cs2340.team35.models.SizePowerupDecorator;
import com.cs2340.team35.models.SpeedPowerupDecorator;

import org.junit.Assert;
import org.junit.Test;

public class PowerupEffectTest {

    @Test
    public void TestHealthPowerup() {
        PlayerModel instance = PlayerModel.getInstance();
        PowerupInterface pi = new SizePowerupDecorator(new PowerupBase(false, 0, 0, "rand", "health"));
        int oldH = instance.getHeight();
        pi.activate();
        int newH = instance.getHeight();

        Assert.assertEquals(oldH/2, newH);
    }

    @Test
    public void TestSpeedPowerup() {
        PlayerModel instance = PlayerModel.getInstance();
        PowerupInterface pi = new SpeedPowerupDecorator(new PowerupBase(false, 0, 0, "rand", "speed"));
        int oldSpe = instance.getSpeed();
        pi.activate();
        int newSpe = instance.getSpeed();

        Assert.assertEquals(oldSpe * 2, newSpe);
    }
}

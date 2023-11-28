package com.cs2340.team35;

import com.cs2340.team35.models.PowerupBase;

import org.junit.Test;
import org.junit.Assert;

public class PowerupSterlingTests {

    @Test
    public void TestIsUsed() {
        PowerupBase pUp = new PowerupBase(false, 5, 5, "pUp", "star");
        boolean isUsed = false;
        Assert.assertEquals(isUsed, pUp.isUsed());
        PowerupBase pUp2 = new PowerupBase(true, 5, 5, "pUp2", "mushroom");
        isUsed = true;
        Assert.assertEquals(isUsed, pUp2.isUsed());
    }
}

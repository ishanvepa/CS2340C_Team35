package com.cs2340.team35;

import android.graphics.Rect;

import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.PowerupBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IshanTest {
    @Test
    public void TestCorrectType() {
        PowerupBase pUp = new PowerupBase(false, 0, 0, "pUp", "size");
        Assert.assertEquals("size", pUp.getType());
    }
    @Test
    public void TestCorrectLength() {
        PowerupBase pUp = new PowerupBase(false, PlayerModel.getInstance().getX(), PlayerModel.getInstance().getY(), "pUp", "size");
        Assert.assertEquals(100, pUp.getLength());
    }
}

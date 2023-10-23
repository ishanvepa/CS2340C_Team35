package com.cs2340.team35;

import com.cs2340.team35.models.WallModel;

import org.junit.Assert;
import org.junit.Test;

public class WallUnitTests {
    @Test
    public void TestWallInit() {
        WallModel w = new WallModel(20, 20, 20, 20);
        Assert.assertEquals(20, w.getHeight());
        Assert.assertEquals(20, w.getWidth());
        Assert.assertEquals(20, w.getLeftMargin());
        Assert.assertEquals(20, w.getTopMargin());
    }

    @Test
    public void TestWallMinimumDimensions() {
        WallModel w = new WallModel(0, 00, 20, 20);
        Assert.assertEquals(10, w.getHeight());
        Assert.assertEquals(10, w.getWidth());
    }
}

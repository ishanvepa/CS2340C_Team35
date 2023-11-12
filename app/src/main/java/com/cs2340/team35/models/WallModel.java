package com.cs2340.team35.models;

import java.util.List;

public class WallModel {
    private int width;
    private int height;
    private int leftMargin;
    private int topMargin;

    public WallModel(int width, int height, int leftMargin, int topMargin) {
        if (width < 10) {
            width = 10;
        }
        if (height < 10) {
            height = 10;
        }
        this.width = width;
        this.height = height;
        this.leftMargin = leftMargin;
        this.topMargin = topMargin;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLeftMargin() {
        return leftMargin;
    }

    public int getTopMargin() {
        return topMargin;
    }

}
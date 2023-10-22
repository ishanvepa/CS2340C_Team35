package com.cs2340.team35.models;

import com.cs2340.team35.viewmodels.PlayerViewModel;

import java.util.ArrayList;
import java.util.List;

public class WallModel implements WallCollisionObservable{
    private int x;
    private int y;
    private int width;
    private int height;
    //wall collision subscriber list
    private List<WallCollisionObservable> WallCollisionObservables = new ArrayList<>();


    public WallModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
//
//    //wall collision subscriber methods
//    public void notifyForCollisions(){
//        for(WallCollisionObservable sub : WallCollisionObservables){
//            sub.onCollision(PlayerViewModel.getInstance());
//        }
//    }
//
//    public void subscribe(WallCollisionObservable sub){
//        WallCollisionObservables.add(sub);
//    }
//
//    public void unsubscribe(WallCollisionObservable sub){
//        WallCollisionObservables.remove(sub);
//
//    }

    @Override
    public void onCollision(PlayerViewModel Subject) {
        Subject.getInstance().setX(100);
        Subject.getInstance().setY(600);

    }

}


interface WallCollisionObservable{
    public void onCollision(PlayerViewModel Subject);
}

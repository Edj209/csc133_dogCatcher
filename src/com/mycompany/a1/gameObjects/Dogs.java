package com.mycompany.a1.gameObjects;

import com.codename1.charts.util.ColorUtil;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Dogs extends Animals{
    public int getScratches() {
        return scratches;
    }

    public void setScratches(int scratches) {
        this.scratches = scratches;
    }

    private int scratches = 0;


    public Dogs() {
        speed = 5;
    }

    //color of dog may change
    @Override
    public void changeColor() {

    }

    @Override
    public void move() {

    }
}

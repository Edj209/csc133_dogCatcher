package com.mycompany.a1;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

/**
 * Created by Edgar on 2/23/2016.
 */
public abstract class GameObject {

    Random randomNum = new Random();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ColorUtil getColor() {
        return color;
    }

    public void setColor(ColorUtil color) {
        this.color = color;
    }

    public Point2D.Float getObjLocation() {
        return objLocation;
    }

    public void setObjLocation(Point2D.Float objLocation) {
        this.objLocation = objLocation;
    }

    private Point2D.Float objLocation;
    private ColorUtil color;
    public abstract void changeColor();
    private int size;

    //set the color of each object
    public void initialColor() {
        int randomR = this.randomNum.nextInt(255);
        int randomG = this.randomNum.nextInt(255);
        int randomB = this.randomNum.nextInt(255);

        color.rgb(randomR, randomG, randomB);
    }

    public String toString(){
        return "location=" + this.objLocation + " color=" + this.color;
    }





}

package com.mycompany.a1.gameObjects;

import com.codename1.charts.util.ColorUtil;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Dogs extends Animals{
    ColorUtil color = new ColorUtil();
    Random randomNum = new Random();

    public int getScratches() {
        return scratches;
    }

    public void setScratches(int scratches) {
        this.scratches = scratches;
    }

    private int scratches;


    public Dogs() {
        speed = 5;
        scratches = 0;
        direction = randomNum.nextInt(360);
    }

    //color of dog may change
    @Override
    public void changeColor() {
        int randomR = this.randomNum.nextInt(255);
        int randomG = this.randomNum.nextInt(255);
        int randomB = this.randomNum.nextInt(255);

        color.rgb(randomR, randomG, randomB);
    }

    @Override
    public void move() {
        direction = direction + randInt(-5, 5);
        int theta = 90 - direction;
        Math.toRadians((double)theta);
        //update new location
        Point2D.Float newLocation = new Point2D.Float();
        newLocation.x = getObjLocation().x + ((float) Math.cos(theta) * speed);
        newLocation.y = getObjLocation().y + ((float) Math.sin(theta) * speed);
        setObjLocation(newLocation);

    }

    public void scratched () {
        scratches++;
        speed--;
        if (scratches > 5)
            scratches = 5;
        if (speed < 0)
            speed = 0;

    }
    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    //print for map
    public String toString(){
        System.out.print("Dog: ");
        String parentDesc = super.toString();
        String myDesc = " direction=" + this.direction + " speed=" + this.speed + " size=" + this.getSize() + " scratches= " + this.scratches;
        return parentDesc + myDesc;
    }
}

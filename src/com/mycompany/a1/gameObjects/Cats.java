package com.mycompany.a1.gameObjects;

import java.util.Random;

import com.codename1.ui.geom.Point2D;


/**
 * Created by Edgar on 2/23/2016.
 */
public class Cats extends Animals {
    Random randomNum = new Random();
    private int theta;
    private int thetaX;
    private int thetaY;


    public Cats() {
        speed = 5;
        direction = randomNum.nextInt(360);
    }

    //empty
    @Override
    public void changeColor() {
    }

    @Override
    public void move() {
        direction = direction + randInt(-5, 5);
        int theta = 90 - direction;
        Math.toRadians((double)theta);
        //update new location
        Point2D newLocation = new Point2D(0, 0);
        newLocation.setX(getObjLocation().getX() + ((double) Math.cos(theta)) * speed);
        newLocation.setY(getObjLocation().getY() + ((double) Math.sin(theta)) * speed);
        
        this.setObjLocation((com.codename1.ui.geom.Point2D) newLocation);
        
//        Point2D newLocation;
//        newLocation.setLocation(getObjLocation().x + ((float) Math.cos(theta) * speed, getObjLocation().y + ((float) Math.sin(theta) * speed);
//        newLocation.y = getObjLocation().y + ((float) Math.sin(theta) * speed);
//        setObjLocation(newLocation);

    }
    
    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public String toString(){
        System.out.print("Cat: ");
        String parentDesc = super.toString();
        String myDesc = " direction=" + this.direction + " speed=" + this.speed + " size=" + this.getSize();
        return parentDesc + myDesc;
    }


}

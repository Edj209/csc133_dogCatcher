package com.mycompany.a1.gameObjects;

import java.awt.geom.Point2D;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Nets extends Catchers{


    public Nets () {
        setSize(100);
    }

    @Override
    public void left() {
        Point2D.Float objLocation = new Point2D.Float((float)this.getObjLocation().getX()-5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    @Override
    public void right() {
        Point2D.Float objLocation = new Point2D.Float((float)this.getObjLocation().getX()+5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    @Override
    public void up() {
        Point2D.Float objLocation = new Point2D.Float((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()+5);
        this.setObjLocation(objLocation);
    }

    @Override
    public void down() {
        Point2D.Float objLocation = new Point2D.Float((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()-5);
        this.setObjLocation(objLocation);
    }

    @Override
    public void jumpToRandomDog(Point2D.Float dogObjLocation) {
        this.setObjLocation(dogObjLocation);
    }

    @Override
    public void jumpToRandomCat(Point2D.Float catObjLocation) {
        this.setObjLocation(catObjLocation);
    }

    @Override
    public void changeColor() {

    }

    public String toString(){
        System.out.print("Net: ");
        String parentDesc = super.toString();
        String myDesc = " size=" + this.getSize();
        return parentDesc + myDesc;
    }
}

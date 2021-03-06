package com.mycompany.a1.gameObjects;

import com.codename1.ui.geom.Point2D;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Nets extends Catchers{


    public Nets () {
        setSize(100);
    }

    @Override
    public void left() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX()-5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    @Override
    public void right() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX()+5, (float) this.getObjLocation().getY());
        this.setObjLocation(objLocation);
    }

    @Override
    public void up() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()+5);
        this.setObjLocation(objLocation);
    }

    @Override
    public void down() {
        Point2D objLocation = new Point2D((float)this.getObjLocation().getX(), (float) this.getObjLocation().getY()-5);
        this.setObjLocation(objLocation);
    }

    @Override
    public void jumpToRandomDog(Point2D dogObjLocation) {
        this.setObjLocation(dogObjLocation);
    }

    @Override
    public void jumpToRandomCat(Point2D catObjLocation) {
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

package com.mycompany.a1.gameObjects;

import java.awt.geom.Point2D;

/**
 * Created by Edgar on 2/23/2016.
 */
public interface IGuided {
    void left();
    void right();
    void up();
    void down();
    void jumpToRandomDog(Point2D.Float dogObjLocation);
    void jumpToRandomCat(Point2D.Float catObjLocation);
}

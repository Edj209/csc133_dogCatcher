package com.mycompany.a1.gameObjects;

import com.mycompany.a1.GameObject;

/**
 * Created by Edgar on 2/23/2016.
 */
public abstract class Animals extends GameObject implements IMoving {
    int speed;
    int direction;
    int unchangableSize;
}

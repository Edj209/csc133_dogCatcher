package com.mycompany.a1;

import com.mycompany.a1.gameObjects.Cats;
import com.mycompany.a1.gameObjects.Dogs;
import com.mycompany.a1.gameObjects.Nets;
import sun.nio.ch.Net;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Edgar on 2/23/2016.
 */
public class GameWorld {
    ArrayList<GameObject> GameObjects = new ArrayList();
    Random randomNum = new Random();
    private int dogsCaptured = 0;
    private int catsCaptured = 0;
    private int dogsRemaining = 0;
    private int catsRemaining = 2;
    private int totalScore = 0;

    //generates the world, adding dogs cats and nets
    public void initLayout() {

        //creates dogs
        for(int i=0; i<2; i++){
            Point2D.Float objLocation = new Point2D.Float(randomNum.nextInt(1000),randomNum.nextInt(610));
            Dogs dog = new Dogs();
            dog.setSize(randInt(20, 50));
            dog.setObjLocation(objLocation);

            GameObjects.add(dog);
        }
        //creates cats
        for(int i=0; i<1; i++){
            Point2D.Float objLocation = new Point2D.Float(randomNum.nextInt(1000),randomNum.nextInt(610));
            Cats cat = new Cats();
            cat.setSize(randInt(20, 50));
            cat.setObjLocation(objLocation);

            GameObjects.add(cat);
        }
        //creates net
        Nets net = new Nets();
        Point2D.Float objLocation = new Point2D.Float(randomNum.nextInt(1000),randomNum.nextInt(610));
        net.setSize(100);

        GameObjects.add(net);
    }

    //expands the net
    public void expand(){
        for(GameObject net : GameObjects) {
            if (net instanceof Nets) {
                net.setSize(net.getSize()+5);
                if(net.getSize()>1000)
                    net.setSize(1000);
            }
        }
    }

    //contracts the net
    public void contract() {
        for(GameObject net : GameObjects) {
            if (net instanceof Nets) {
                net.setSize(net.getSize()-5);
                if(net.getSize()<50)
                    net.setSize(50);
            }
        }
    }

    //scoops up all the animals in the net
    public void scoop() {
        for(GameObject catDog : GameObjects){
            if(catDog instanceof Cats) {
                catsCaptured++;
                catsRemaining--;
                totalScore = totalScore - 10;
                GameObjects.remove(catDog);
            }
            if(catDog instanceof Dogs){
                dogsCaptured++;
                dogsRemaining--;
                totalScore = (totalScore + 10 - ((Dogs) catDog).getScratches());
                GameObjects.remove(catDog);
            }
        }
    }

    //next 6 methods concern the movement of the net by the player
    public void right() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).right();
            }
        }
    }

    public void left() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).left();
            }
        }
    }

    public void up() {
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).up();
            }
        }
    }

    public void down(){
        for(GameObject net : GameObjects){
            if(net instanceof Nets){
                ((Nets) net).down();
            }
        }
    }

    public void netToRandomDog() {
        for (GameObject dogLocation : GameObjects) {
            if (dogLocation instanceof Dogs) {
                Point2D.Float objLocation = dogLocation.getObjLocation();
                for (GameObject net : GameObjects) {
                    if (net instanceof Nets) {
                        ((Nets) net).jumpToRandomDog(objLocation);
                    }
                }
            }
        }
    }

    public void netToRandomCat() {
        for (GameObject catLocation : GameObjects) {
            if (catLocation instanceof Cats) {
                Point2D.Float objLocation = catLocation.getObjLocation();
                for (GameObject net : GameObjects) {
                    if (net instanceof Nets) {
                        ((Nets) net).jumpToRandomCat(objLocation);
                    }
                }
            }
            else {
                System.out.println("There are no more cats left.");
            }
        }
    }

    public void catCollision() {
        Set<Cats> uniqueCats = new HashSet<Cats>();
        for(GameObject cat : GameObjects){
            if(cat instanceof Cats){
                Cats uniqueCat = (Cats) cat;
                uniqueCats.add(uniqueCat);
            }
        }
        int uniqueItemCounter = uniqueCats.size();
        if(uniqueItemCounter >= 2){
            for(GameObject cat : GameObjects){
                if(cat instanceof Cats){
                    Point2D.Float objLocation = new Point2D.Float((float) cat.getObjLocation().getX()+5, (float) cat.getObjLocation().getY()+5);
                    Cats kitty = new Cats();
                    kitty.setSize(randInt(20, 50));
                    kitty.setObjLocation(objLocation);

                    GameObjects.add(kitty);
                }
            }
        }

    }

    public void catDogFight() {}

    public void tick() {}

    public void points() {}

    public void map() {}

    public void quit() {}

    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


}

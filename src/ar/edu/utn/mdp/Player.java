package ar.edu.utn.mdp;

import ar.edu.utn.mdp.Component;

public class Player extends Car {

    private int speed;
    private int fuel;
    private int score;

    //*************************constructor***************************************


    public Player(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, int speed, int fuel, int score) {
        super(name, x, y, rotation, width, height, image, hitBox);
        this.speed = speed;
        this.fuel = fuel;
        this.score = score;
    }

    //**************************GetsAndSets**************************************

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    @Override
    public HitBox getHitBox() {
        return super.getHitBox();
    }

    //***************************Metods******************************************

    public void editSpeed(){

    }

    public void editFuel(){

    }

    public void editScore(){

    }


}

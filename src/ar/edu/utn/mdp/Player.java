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

    //***************************Metods******************************************
    public void move()
    {
        if(Input.getKey(37))
            setX(getX() - 1);
        if(Input.getKey(39))
            setX(getX() + 1);
        if(Input.getKey(38) && (speed<400))
        {
            setSpeed(getSpeed()+1);
        }
        else if(speed>300)
        {
            setSpeed(getSpeed()-1);
        }
        if(Input.getKey(40) && (speed>100))
        {
            setSpeed(getSpeed()-1);
        }

    }

    public void editSpeed()
    {

    }

    public void editFuel(){

    }

    public void editScore(){

    }


}

package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.utils.Input;

public class Player extends Car {

    private double speed;
    private double fuel;
    private double score;

    //*************************constructor***************************************


    public Player(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed, double fuel, double score) {
        super(name, x, y, rotation, width, height, image, hitBox);
        this.speed = speed;
        this.fuel = fuel;
        this.score = score;
    }

    //**************************GetsAndSets**************************************

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getScore() { return score; }

    public void setScore(double score) { this.score = score; }

    @Override
    public HitBox getHitBox() {
        return super.getHitBox();
    }

    //***************************Metods******************************************
    public void scoreCounter()
    {
        if(speed>0)
        {
            setScore(score+(speed*0.0005));
        }
    }

    public void fuelConsumed()
    {
        if(speed>0 && fuel>0)
        {
            setFuel(getFuel()-0.05);
        }
    }

    public void move()
    {
        if(speed>0)
        {
            if (Input.getKey(37))
                setX(getX() - 1);
            if (Input.getKey(39))
                setX(getX() + 1);
        }
        if(fuel>0)
        {
            if (Input.getKey(38) && (speed < 400)){
                if(speed<=100)
                    setSpeed(getSpeed() + 0.3);
                else if(speed>=100 && speed<=200)
                    setSpeed(getSpeed() + 0.4);
                else
                    setSpeed(getSpeed() + 0.5);
            }

            else if (speed > 300)
                setSpeed(getSpeed() - 1);
            if (Input.getKey(40) && (speed > 100))
                setSpeed(getSpeed() - 0.75);
        } else if(speed>=1)
            setSpeed(speed-(speed/60));
        else
            speed=0;
    }

    public void editSpeedCollision()
    {
        if(getHitBox().isCollision()){
            if(getSpeed()>=100) {
                setSpeed(getSpeed() * 0.90);
            }else{
                setSpeed(getSpeed() * 0.98);
            }
            getHitBox().setCollision(false);
        }
    }

    public void editFuel(){

    }

    public void editScore(){

    }


}

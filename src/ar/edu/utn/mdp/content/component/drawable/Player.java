package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

public class Player extends Car {

    private double fuel;
    private double score;

    //*************************constructor***************************************


    public Player(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed, double fuel, double score) {
        super(name, x, y, rotation, width, height, image, hitBox, speed);
        this.fuel = fuel;
        this.score = score;
    }

    //**************************GetsAndSets**************************************



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
        if(getSpeed()>0)
        {
            setScore(score+(getSpeed()*0.0005));
        }
    }

    public void fuelConsumed()
    {
        if(getSpeed()>0 && fuel>0)
        {
            setFuel(getFuel()-0.05);
        }
    }

    public void move()
    {
        if(getSpeed()>0.99){
            if (Input.getKey(37))
                setX(getX() - 1);
            if (Input.getKey(39))
                setX(getX() + 1);
        }
        if(fuel>0){
            if (Input.getKey(38) && (getSpeed() < 400)){
                if(getSpeed()<=100)
                    setSpeed(getSpeed()+getSpeed()/40);
                else
                    setSpeed(getSpeed()+getSpeed()/150);

            } else if (getSpeed() > 301)
                setSpeed(getSpeed() - 1);
            if (Input.getKey(40) && (getSpeed() > 101))
                setSpeed(getSpeed() - 0.75);
        } else if(getSpeed()>=1)
            setSpeed(getSpeed()-(getSpeed()/60));
        else
            setSpeed(0);
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
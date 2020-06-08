package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Player extends Car {

    private double fuel;
    private double score;
    private int counter;
    private boolean girar;
    double velocidadInicial=0;
    int paso=30;

    //*************************constructor***************************************


    public Player(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed, double fuel, double score) {
        super(name, x, y, rotation, width, height, image, hitBox, speed);
        this.fuel = fuel;
        this.score = score;
        counter=0;
        girar=false;
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

        if(!getHitBox().isCollision()&&!girar){
            if (getSpeed() > 0.99) {
                if (Input.getKey(37))
                    setX(getX() - 1);
                if (Input.getKey(39))
                    setX(getX() + 1);
            }
            if (fuel > 0) {
                if (Input.getKey(38) && (getSpeed() < 400)) {
                    if (getSpeed() <= 100)
                        setSpeed(getSpeed() + getSpeed() / 40);
                    else
                        setSpeed(getSpeed() + getSpeed() / 150);

                } else if (getSpeed() > 301)
                    setSpeed(getSpeed() - 1);
                if (Input.getKey(40) && (getSpeed() > 101))
                    setSpeed(getSpeed() - 0.75);
            } else if (getSpeed() >= 1)
                setSpeed(getSpeed() - (getSpeed() / 60));
            else
                setSpeed(0);
        }
        else if(girar)
        {

            if(counter<paso)
            {
                if(counter%2==0)
                {
                    carSpin(velocidadInicial, paso);
                }
                counter=counter+1;
            }
            else
            {
                girar=false;
                counter=0;

            }
        }
        else
        {
            getHitBox().setCollision(false);
            girar=true;
            velocidadInicial=getSpeed();
        }
    }

    private void carSpin(double velocidadInicial,int paso)
    {
            setX(getX()+1);
            setRotation(getRotation()+(720/paso));
            setSpeed(getSpeed()-((velocidadInicial*0.5)/paso));
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

    @Override
    public void draw(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(x,y);
        at.scale(3.125 ,3.125);
        at.rotate(Math.toRadians(rotation), 8 , 8);
        ((Graphics2D)g).drawImage(super.getImage(), at,null);

    }

    public void editFuel(){

    }

    public void editScore(){

    }


}

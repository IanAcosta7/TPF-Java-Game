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


    /**
     *
     * @return Retorna el combutible
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Setea el combustible
     * @param fuel parametro para setear
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    /**
     *
     * @return Retorna la puntuacion del jugador.
     */
    public double getScore() { return score; }

    /**
     *
     * @param score Parametro para setear el puntaje
     */
    public void setScore(double score) { this.score = score; }

    @Override
    public HitBox getHitBox() {
        return super.getHitBox();
    }

    //***************************Metods******************************************

    /**
     * El metodo aumenta el puntaje segun la velocidad del jugador.
     */
    public void scoreCounter()
    {
        if(getSpeed()>0)
        {
            setScore(score+(getSpeed()*0.0005));
        }
    }

    /**
     * El metodo reduce el nivel de combustible
     */
    public void fuelConsumed()
    {
        if(getSpeed()>0 && fuel>0)
        {
            setFuel(getFuel()-0.05);
        }
    }

    /**
     * El metodo move determina movimiento del jugador, si puede desplazarce en eje X, velocidad por frenado, y si existe colision, lo hace girar.
     */
    public void move()
    {

        if(!getHitBox().isCollision()&&!girar){
            if (getSpeed() > 0.99) {
                if (Input.getKey(37))
                    setX(getX() - 3);
                if (Input.getKey(39))
                    setX(getX() + 3);
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

                carSpin(velocidadInicial, paso);
                counter=counter+1;

                if (counter == paso - 1)
                    getHitBox().setCollision(false);
            }
            else
            {
                girar=false;
                counter=0;

            }
        }
        else
        {
            girar=true;
            velocidadInicial=getSpeed();
        }
    }

    /**
     * Metodo que hace que el auto gire.
     * @param velocidadInicial Velocidad a la que va el jugador.
     * @param paso Determina cuantos pasos durara la rotacion del auto.
     */
    private void carSpin(double velocidadInicial, int paso)
    {
            setX(getX()+1);
            setRotation(getRotation()+(720/paso)); // 720 por 2 vueltas
            setSpeed(getSpeed()-((velocidadInicial*0.9)/paso)); // se frena un 90%
    }

    @Override
    public void draw(Graphics g) {
        AffineTransform at = AffineTransform.getTranslateInstance(x,y);
        at.scale(3.125 ,3.125);
        at.rotate(Math.toRadians(rotation), 8 , 8);
        ((Graphics2D)g).drawImage(super.getImage(), at,null);

    }
}

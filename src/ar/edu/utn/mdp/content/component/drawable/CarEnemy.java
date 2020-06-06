package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

public class CarEnemy extends Car{


    public CarEnemy(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed) {
        super(name, x, y, rotation, width, height, image, hitBox, speed);
    }


    public void moveCar(double speedAuto){

        double var = 2/(1+Math.pow(1.01,-speedAuto+200))-1;

        setY((int)(getY()+((speedAuto*0.02*var)-getSpeed())));





    }
}

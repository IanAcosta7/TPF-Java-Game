package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

public class CarEnemy extends Car{


    public CarEnemy(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed) {
        super(name, x, y, rotation, width, height, image, hitBox, speed);
    }


    public void moveCar(double speedAuto){
        double var = (1d/20d) * speedAuto - 10;

        setY((int)Math.round(getY()+var));
        getHitBox().setY(getY());
    }

}

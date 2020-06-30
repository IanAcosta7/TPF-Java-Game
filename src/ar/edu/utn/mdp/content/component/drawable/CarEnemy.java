package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

import java.util.Random;

public class CarEnemy extends Car{

    private static int number;

    public CarEnemy(String name, int rotation, int width, int height, String image, HitBox hitBox, double speed) {
        super(name,0 , 0, rotation, width, height, image, hitBox, speed);
        super.setX(randomRail());
        super.setY(generateRandomY());
        number++;
    }

    /**
     * El metodo determina una velocidad para el auto enemigo
     * @param speedAuto Se le pasa la velocidad del auto
     */
    public void moveCar(double speedAuto){
        double var = (1d/20d) * speedAuto - 10;
        setY((int)Math.round(getY()+var));
        getHitBox().setY(getY());
    }

    /**
     * El metodo determina la Creacion de un auto Enemigo en un determinado carril
     * @return Retorna una posicion en Eje X
     */
    public int randomRail(){
        int[] arrayRail ={400-25,400-85,400-140};
        int x = new Random().nextInt(arrayRail.length);
        return arrayRail[x];
    }

    /**
     *
     * @return Retorna un numero
     */
    public static int getNumber() {
        return number;
    }

    /**
     *
     * @param number Establece un numero para asignarlo a un auto enemigo
     */
    public static void setNumber(int number) {
        CarEnemy.number = number;
    }

    private int generateRandomY(){
        int[] arrayRail ={-200,-400,-600,-800,-1000,-700};
        int x = new Random().nextInt(arrayRail.length);
        return arrayRail[x];
    }

    public static void restarCarNumber()
    {
        number--;
    }
}

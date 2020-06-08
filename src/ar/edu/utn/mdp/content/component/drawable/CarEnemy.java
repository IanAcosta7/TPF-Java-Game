package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.utils.Input;

import java.util.Random;

public class CarEnemy extends Car{

    private static int number;

    public CarEnemy(String name, int y, int rotation, int width, int height, String image, HitBox hitBox, double speed) {
        super(name,0 , y, rotation, width, height, image, hitBox, speed);
        super.setX(randomRail());
        number++;
        //super.setName(generateRandomWord());
    }

    public void moveCar(double speedAuto){
        double var = (1d/20d) * speedAuto - 10;

        setY((int)Math.round(getY()+var));
        getHitBox().setY(getY());
    }

    public int randomRail(){
        int[] arrayRail ={400-25,400-85,400-140};
        int x = new Random().nextInt(arrayRail.length);
        return arrayRail[x];
    }

    public String generateRandomWord() {
        int wordLength = 5;
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        CarEnemy.number = number;
    }
}

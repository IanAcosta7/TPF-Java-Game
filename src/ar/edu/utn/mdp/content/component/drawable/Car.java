package ar.edu.utn.mdp.content.component.drawable;

public class Car extends Sprite {
    private double speed;

    public Car(String name, int x, int y, int rotation, int width, int height, String image, double speed) {
        super(name, x, y, rotation, width, height, image);
        this.speed = speed;
    }
    public Car(String name, int x, int y, int rotation, int width, int height, String image, double speed, HitBox hitBox) {
        super(name, x, y, rotation, width, height, image, hitBox);
        this.speed = speed;
    }


    /**
     *
     * @return Retorna la velocidad del auto
     */
    public double getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed Establece la velocidad del auto
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     *
     * @param x Establece en el eje X a el auto
     */
    @Override
    public void setX(int x) {
        super.setX(x);
        hitBox.setX(x + 50/4);//todo: cambiar esta porcion por una variable
    }



}

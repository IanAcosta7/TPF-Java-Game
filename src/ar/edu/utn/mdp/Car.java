package ar.edu.utn.mdp;

public class Car extends Sprite{
    private HitBox hitBox;

    public Car(int x, int y, int rotation, int width, int height, String image, HitBox hitBox) {
        super(x, y, rotation, width, height, image);
        this.hitBox = hitBox;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        hitBox.setX(x + 50/3);
    }
}

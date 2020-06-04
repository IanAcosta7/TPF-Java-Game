package ar.edu.utn.mdp.content.component;

public class Car extends Sprite {
    private HitBox hitBox;

    public Car(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox) {
        super(name, x, y, rotation, width, height, image);
        this.hitBox = hitBox;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        hitBox.setX(x + 50/4);//todo: cambiar esta porcion por una variable
    }


}

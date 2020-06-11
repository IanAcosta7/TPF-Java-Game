package ar.edu.utn.mdp.content.component.drawable;

public class Tile extends Sprite {
    private HitBox hitBox;

    public Tile(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox) {
        super(name, x, y, rotation, width, height, image);
        this.hitBox = hitBox;
    }

    public Tile(String name, int x, int y, int rotation, int width, int height, HitBox hitBox) {
        super(name, x, y, rotation, width, height);
        this.hitBox = hitBox;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }
}

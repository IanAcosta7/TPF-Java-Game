package ar.edu.utn.mdp.content.component.drawable;

public class Tile extends Sprite {
    private HitBox hitbox;

    public Tile(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitbox) {
        super(name, x, y, rotation, width, height, image);
        this.hitbox = hitbox;
    }

    public Tile(String name, int x, int y, int rotation, int width, int height, HitBox hitbox) {
        super(name, x, y, rotation, width, height);
        this.hitbox = hitbox;
    }

    public HitBox getHitbox() {
        return hitbox;
    }
}

package ar.edu.utn.mdp.content.component.drawable;

public class Tile extends Sprite {
    private HitBox hitBox;
    private boolean structure;

    public Tile(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox) {
        super(name, x, y, rotation, width, height, image);
        this.hitBox = hitBox;
        this.structure = false;
    }

    public Tile(String name, int x, int y, int rotation, int width, int height, HitBox hitBox) {
        super(name, x, y, rotation, width, height);
        this.hitBox = hitBox;
        this.structure = false;
    }

    public boolean isStructure() {
        return structure;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setStructure(boolean structure) {
        this.structure = structure;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }
}

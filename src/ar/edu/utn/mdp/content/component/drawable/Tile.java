package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.tileset.side.Structure;

public class Tile extends Sprite {
    private HitBox hitBox;
    private Structure partOfStructure;

    public Tile(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox) {
        super(name, x, y, rotation, width, height, image);
        this.hitBox = hitBox;
        this.partOfStructure = null;
    }

    public Tile(String name, int x, int y, int rotation, int width, int height, HitBox hitBox) {
        super(name, x, y, rotation, width, height);
        this.hitBox = hitBox;
        this.partOfStructure = null;
    }

    public Structure getPartOfStructure() {
        return partOfStructure;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setPartOfStructure(Structure partOfStructure) {
        this.partOfStructure = partOfStructure;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }
}

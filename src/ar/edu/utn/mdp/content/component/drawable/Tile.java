package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.tileset.side.Structure;

public class Tile extends Sprite {

    public Tile(String name, int x, int y, int rotation, int width, int height, String image) {
        super(name, x, y, rotation, width, height, image);
    }

    public Tile(String name, int x, int y, int rotation, int width, int height) {
        super(name, x, y, rotation, width, height);
    }

}

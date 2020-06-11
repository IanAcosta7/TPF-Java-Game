package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.HitBox;
import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grass extends Side {

    public Grass() {
        super();
    }

    private BufferedImage getRandomGrass() {
        String[] spriteNames = {
                "Pasto/PastoParejo",
                "Pasto/PastoAlter",
                "Pasto/PastoAlter2",
                "Pasto/PastoFlorAmarilla",
                "Pasto/PastoFlorRoja"
        };

        return Loader.getSprites().get(spriteNames[(int)(Math.random() * spriteNames.length)]);
    }

    @Override
    public void setTiles(ArrayList<ArrayList<Tile>> tiles) {

        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Tile> row = tiles.get(i);
            for (Tile tile : row) {
                tile.setImage(getRandomGrass());
                tile.setHitBox(new HitBox(tile.getName() + "HB", tile.getX(), tile.getY(), tile.getRotation(), tile.getHeight(), tile.getWidth()));
            }
        }
    }
}

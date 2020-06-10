package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.Sprite;
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
    public void setTiles(ArrayList<ArrayList<Sprite>> tiles) {

        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Sprite> row = tiles.get(i);
            for (Sprite tile : row)
                tile.setImage(getRandomGrass());
        }
    }
}

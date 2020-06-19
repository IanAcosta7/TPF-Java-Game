package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.HitBox;
import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grass extends Side {

    private int counter;

    public Grass() {
        super();
        this.counter = 0;
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
    public void modifyTiles() {
        // Draw Background Grass
        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Tile> row = tiles.get(i);
            for (int j = 0; j < row.size(); j++) {
                Tile tile = row.get(j);

                tile.setImage(getRandomGrass());
                tile.setHitBox(new HitBox(tile.getName() + "HB", tile.getX(), tile.getY(), tile.getRotation(), tile.getHeight(), tile.getWidth()));
            }
        }
    }

    @Override
    public void modifyFirstRow(int rowNumber) {
        final int treeEach = 10;

        // Draw Background Grass
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i).get(rowNumber);

            tile.setPartOfStructure(null);
            tile.setImage(getRandomGrass());
        }

        // Draw Tree
        if (counter < Structure.ARBOL.getSizeY()) {
            tiles.get(4).get(rowNumber).setImage(Structure.ARBOL.getImage(0, counter));
            tiles.get(5).get(rowNumber).setImage(Structure.ARBOL.getImage(1, counter));
        }

        if (counter > Structure.ARBOL.getSizeY() + treeEach) {
            counter = 0;
        } else {
            counter++;
        }

    }
}

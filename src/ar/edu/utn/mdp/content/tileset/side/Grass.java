package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.HitBox;
import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Grass extends Side {

    private boolean drawTree;
    private int treePos;
    private int counter;

    public Grass() {
        super();
        this.drawTree = false;
        this.treePos = 1;
        this.counter = 0;

        init();
    }

    private void init() {
        structures.add(Structure.ARBOL);
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

    private BufferedImage getTreeImage(int pos) {
        String[] spriteNames = {
                "Arbol/arbolito_01",
                "Arbol/arbolito_02",
                "Arbol/arbolito_03",
                "Arbol/arbolito_04",
                "Arbol/arbolito_05",
                "Arbol/arbolito_06"
        };

        return Loader.getSprites().get(spriteNames[pos]);
    }

    /*private Structure getTreeStructure() {
        ArrayList<ArrayList<Tile>> treeTiles = new ArrayList<>();

        treeTiles.set(0, new ArrayList<>());
        treeTiles.set(1, new ArrayList<>());

        treeTiles.get(0).set()
    }*/

    @Override
    protected void loadStructure(int x, int y, Structure structure) {
        for (int i = 0; i < structure.getSizeX(); i++) {
            for (int j = 0; j < structure.getSizeY(); j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX < tiles.size() && newY < tiles.get(newX).size())
                    tiles.get(newX).get(newY).setImage(structure.getImage(i, j));
            }
        }
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

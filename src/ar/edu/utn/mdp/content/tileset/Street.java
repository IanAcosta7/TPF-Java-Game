package ar.edu.utn.mdp.content.tileset;

import ar.edu.utn.mdp.content.component.drawable.Sprite;
import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class  Street extends TileSet {
    private int start;
    private int end;
    private boolean hasLine;
    private int lineEach;
    private int lineLength;
    private int counter;

    public Street(int start, int end, int lineEach, int lineLength) {
        this.start = start;
        this.end = end;
        this.hasLine = false;
        this.lineEach = lineEach;
        this.lineLength = lineLength;
        this.counter = 0;
    }

    private BufferedImage getStreetImage(int pos, int streetLength) {
        BufferedImage street = Loader.getSprites().get("Calle/asfaltoLiso");

        //LINES
        if ((pos == streetLength / 3 || pos == streetLength - streetLength / 3 - 1) && hasLine)
            street = Loader.getSprites().get("Calle/asfaltoConLinea");

        return street;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public void modifyTiles() {

        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Tile> row = tiles.get(i);

            for (Sprite tile : row) {
                if (i == 0)
                    tile.setImage(Loader.getSprites().get("Calle/asfaltoLadoIzq"));
                else if (i == tiles.size() - 1)
                    tile.setImage(Loader.getSprites().get("Calle/asfaltoLadoDer"));
                else
                    tile.setImage(getStreetImage(i, tiles.size()));
            }
        }

    }

    @Override
    public void modifyFirstRow(int row) {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i).get(row);

            if (counter < lineLength) {
                hasLine = true;
            } else {
                hasLine = false;
            }

            if (counter == lineLength + lineEach) {

                counter = 0;
            }

            if (i == 0)
                tile.setImage(Loader.getSprites().get("Calle/asfaltoLadoIzq"));
            else if (i == tiles.size() - 1)
                tile.setImage(Loader.getSprites().get("Calle/asfaltoLadoDer"));
            else
                tile.setImage(getStreetImage(i, tiles.size()));
        }

        counter++;
    }
}

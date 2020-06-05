package ar.edu.utn.mdp.content;

import ar.edu.utn.mdp.content.component.*;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grid extends Component {
    private int tileSize;
    private ArrayList<ArrayList<Sprite>> tiles;

    private int streetStart;
    private int streetEnd;

    private double counter;
    private boolean hasLine;
    private int lineEach;
    private int lineLength;
    private int streetCounter;

    public Grid(String name, int x, int y, int tileSize, int tileAmountX, int tileAmountY) {
        super(name, x, y, 0, tileAmountX * tileSize, tileAmountY * tileSize);
        tiles = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.counter = 0;
        this.streetStart = 0;
        this.streetEnd = 0;
        this.hasLine = false;
        this.lineEach = 12;
        this.lineLength = 3;
        this.streetCounter = 0;
        init(tileAmountX, tileAmountY);
    }

    private void init(int tileAmountX, int tileAmountY) {
        for (int i = 0; i < tileAmountX; i++) {
            tiles.add(new ArrayList<>());
            for (int j = 0; j < tileAmountY; j++) {
                tiles.get(i).add(new Sprite(i + "-" + j, x + i * tileSize, y + j * tileSize, 0, tileSize, tileSize));
            }
        }
    }

    public void setTiles() {
        for (ArrayList<Sprite> tile : tiles) {
            for (int i = 0; i < tile.size(); i++) {
                setRowImages(i, true);
            }
        }
    }

    private void setRowImages(int row, boolean start) {
        int i = 0;

        if (streetStart < tiles.size() && streetEnd < tiles.size()) {

            if (start) {

            } else {
                if (streetCounter > lineEach + lineLength)
                    streetCounter = 0;

                hasLine = streetCounter >= lineEach && streetCounter < lineEach + lineLength;

                streetCounter++;
            }

            while (i < streetStart) {
                tiles.get(i).get(row).setImage(getRandomGrass());
                i++;
            }

            while (i < streetEnd) {
                tiles.get(i).get(row).setImage(getStreetImage(i));
                i++;
            }


        }

        while (i < tiles.size()) {
            tiles.get(i).get(row).setImage(getRandomGrass());
            i++;
        }
    }

    public void update(double speed) {

        if (counter > 400) {
            moveTiles();
            setRowImages(0, false);
            if (speed > 50) {
                moveTiles();
                setRowImages(0, false);
            }
            counter = 0;
        }

        counter += speed;
    }

    private void moveTiles() {
        for (int i = 0; i < tiles.size(); i++) {
            BufferedImage prevImage = null;
            for (int j = 0; j < tiles.get(i).size(); j++) {
                BufferedImage aux = tiles.get(i).get(j).getImage();

                if (prevImage != null)
                    tiles.get(i).get(j).setImage(prevImage);

                prevImage = aux;
            }
        }
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

    private BufferedImage getStreetImage(int pos) {
        BufferedImage street = Loader.getSprites().get("Calle/asfaltoLiso");

        // BORDERS
        if (pos == streetStart)
            street = Loader.getSprites().get("Calle/asfaltoLadoIzq");
        if (pos == streetEnd - 1)
            street = Loader.getSprites().get("Calle/asfaltoLadoDer");

        //LINES
        int streetLength = streetEnd - streetStart;
        if ((pos == (int)(streetStart + streetLength / 3) || pos == (int)((streetEnd - 1) - streetLength / 3)) && hasLine)
            street = Loader.getSprites().get("Calle/asfaltoConLinea");

        return street;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStreetStart(int streetStart) {
        this.streetStart = streetStart;
    }

    public void setStreetEnd(int streetEnd) {
        this.streetEnd = streetEnd;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public Sprite getTile(int x, int y) {
        return tiles.get(x).get(y);
    }

    public ArrayList<ArrayList<Sprite>> getTiles() {
        return this.tiles;
    }
}

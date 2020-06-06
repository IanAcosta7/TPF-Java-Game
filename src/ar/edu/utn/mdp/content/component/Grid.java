package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.Street;
import ar.edu.utn.mdp.content.component.drawable.Sprite;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grid extends Component {
    private int tileSize;
    private ArrayList<ArrayList<Sprite>> tiles;
    private double counter;
    private int firstRow;
    private Street street;

    public Grid(String name, int x, int y, int tileSize, int tileAmountX, int tileAmountY, Street street) {
        super(name, x, y, 0, tileAmountX * tileSize, tileAmountY * tileSize);
        tiles = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.counter = 0;
        this.firstRow = 0;
        this.street = street;
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

        // SI HAY CALLE VALIDA
        if (street.getStart() < tiles.size() && street.getEnd() < tiles.size()) {
            if (start) {
                // CODIGO DE COMIENZO DE CARRERA
            } else
                street.count();

            while (i < street.getStart()) {
                tiles.get(i).get(row).setImage(getRandomGrass());
                i++;
            }

            while (i < street.getEnd()) {
                tiles.get(i).get(row).setImage(street.getStreetImage(i));
                i++;
            }
        }

        while (i < tiles.size()) {
            tiles.get(i).get(row).setImage(getRandomGrass());
            i++;
        }
    }

    public void update(double speed) {

        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Sprite> tile = tiles.get(i);

            for (int j = 0; j < tile.size(); j++) {
                Sprite sprite = tile.get(j);
                double pixelPerSpeed = (1d / 10d) * speed;

                if (sprite.getY() + tileSize <= height) {

                    sprite.setY(sprite.getY() + (int) Math.round(pixelPerSpeed));
                } else {
                    sprite.setY(sprite.getY() - height + (int)Math.round(pixelPerSpeed));
                    //sprite.setY(tile.get(firstRow).getY() - tileSize + (int)Math.round(pixelPerSpeed));
                    //sprite.setY(y + (int)Math.round(pixelPerSpeed));

                    if (i == tiles.size() - 1) {
                        setRowImages(j, false);
                        //firstRow = j;
                    }
                }
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

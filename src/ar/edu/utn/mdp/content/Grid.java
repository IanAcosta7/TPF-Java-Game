package ar.edu.utn.mdp.content;

import ar.edu.utn.mdp.content.component.*;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grid {
    private int x;
    private int y;
    private int tileSize;
    private ArrayList<ArrayList<Sprite>> tiles;

    private double counter;

    public Grid(int x, int y, int tileSize, int tileAmountX, int tileAmountY) {
        tiles = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.counter = 0;
        init(tileAmountX, tileAmountY);
    }

    private void init(int tileAmountX, int tileAmountY) {
        for (int i = 0; i < tileAmountX; i++) {
            tiles.add(new ArrayList<>());
            for (int j = 0; j < tileAmountY; j++) {
                tiles.get(i).add(new Sprite(Integer.toString(i) + Integer.toString(j), x + i * tileSize, y + j * tileSize, 0, tileSize, tileSize));
            }
        }
    }

    public void update(double speed) {

        if (counter > 299) {
            moveTiles();
            generateNewSprites();
            counter = 0;
        }

        counter += speed;
        System.out.println((int)speed);
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

    private void generateNewSprites() {
        String[] spriteNames = {
                "pastoFinal",
                "PastoAlter",
                "PastoAlter2",
                "PastoFlorAmarilla",
                "PastoFlorRoja"
        };

        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).get(0).setImage(Loader.getSprites().get(spriteNames[(int)(Math.random() * 5)]));
        }
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

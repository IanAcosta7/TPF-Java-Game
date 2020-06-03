package ar.edu.utn.mdp;

import java.util.ArrayList;

public class Grid {
    private int x;
    private int y;
    private int tileSize;
    private ArrayList<ArrayList<Sprite>> tiles;

    public Grid(int x, int y, int tileSize, int tileAmountX, int tileAmountY) {
        tiles = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        init(tileAmountX, tileAmountY);
    }

    private void init(int tileAmountX, int tileAmountY) {
        for (int i = 0; i < tileAmountX; i++) {
            tiles.add(new ArrayList<>());
            for (int j = 0; j < tileAmountY; j++) {
                tiles.get(i).add(new Sprite(x + i * tileSize, y + j * tileSize, 0, tileSize, tileSize));
            }
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

package ar.edu.utn.mdp.content.tileset;

import ar.edu.utn.mdp.content.component.drawable.Tile;

import java.util.ArrayList;

public abstract class TileSet {

    protected ArrayList<ArrayList<Tile>> tiles;

    public TileSet() {
        this.tiles = null;
    }

    public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
        this.tiles = tiles;
    }

    public abstract void modifyTiles();

    public abstract void modifyFirstRow(int row);
}

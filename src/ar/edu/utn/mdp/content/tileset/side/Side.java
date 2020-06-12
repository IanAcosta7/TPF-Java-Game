package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.content.tileset.TileSet;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Side  extends TileSet {

    protected HashSet<Structure> structures;

    public Side() {
        structures = new HashSet<>();
    }

    protected abstract void loadStructure(int x, int y, Structure structure);
}

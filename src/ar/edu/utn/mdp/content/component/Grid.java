package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.content.tileset.side.Side;
import ar.edu.utn.mdp.content.tileset.Street;

import java.util.ArrayList;

public class Grid extends Component {
    private int tileSize;
    private final ArrayList<ArrayList<Tile>> tiles;
    private final Side leftSide;
    private final Side rightSide;
    private final Street street;

    public Grid(String name, int x, int y, int tileSize, int tileAmountX, int tileAmountY, Side leftSide, Side rightSide, Street street) {
        super(name, x, y, 0, tileAmountX * tileSize, tileAmountY * tileSize);

        tiles = new ArrayList<>();
        this.tileSize = tileSize;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.street = street;

        init(tileAmountX, tileAmountY);
    }

    private void init(int tileAmountX, int tileAmountY) {
        for (int i = 0; i < tileAmountX; i++) {
            tiles.add(new ArrayList<>());
            for (int j = 0; j < tileAmountY; j++) {
                tiles.get(i).add(new Tile(i + "-" + j, x + i * tileSize, y + j * tileSize, 0, tileSize, tileSize, null));
            }
        }

        setImages();
    }

    private void setImages() {
        leftSide.setTiles(new ArrayList<>(tiles.subList(0, street.getStart())));
        leftSide.modifyTiles();

        rightSide.setTiles(new ArrayList<>(tiles.subList(street.getEnd(), tiles.size())));
        rightSide.modifyTiles();

        street.setTiles(new ArrayList<>(tiles.subList(street.getStart(), street.getEnd())));
        street.modifyTiles();
    }

    public void update(double speed) {

        for (int i = 0; i < tiles.size(); i++) {
            ArrayList<Tile> row = tiles.get(i);

            for (int j = 0; j < row.size(); j++) {
                Tile tile = row.get(j);

                final double portion = 0.1;
                double pixelPerSpeed = portion * speed; // La grid se mueve una porcion de la velocidad del jugador.

                if (tile.getY() + tileSize <= y + height) {
                    tile.setY(tile.getY() + (int) Math.round(pixelPerSpeed)); // Se mueven los tiles de a N pixeles
                } else {
                    // Si la fila llego al fin de la grid vuelve hacia arriba
                    tile.setY((tile.getY() + tileSize) - height + (int)Math.round(pixelPerSpeed));

                    // Y se vuelven a dibujar nuevas imagenes aleatorias
                    if (i == tiles.size() - 1) {
                        leftSide.modifyFirstRow(j);
                        rightSide.modifyFirstRow(j);
                        street.modifyFirstRow(j);
                    }
                }
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

    public ArrayList<ArrayList<Tile>> getTiles() {
        return this.tiles;
    }
}

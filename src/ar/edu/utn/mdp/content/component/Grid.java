package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.content.tileset.side.Side;
import ar.edu.utn.mdp.content.tileset.Street;
import ar.edu.utn.mdp.content.component.drawable.Sprite;
import ar.edu.utn.mdp.utils.Loader;

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
        //setAllImages();
    }

    private void setImages() {
        leftSide.setTiles(new ArrayList<>(tiles.subList(0, street.getStart())));
        leftSide.modifyTiles();

        rightSide.setTiles(new ArrayList<>(tiles.subList(street.getEnd(), tiles.size())));
        rightSide.modifyTiles();

        street.setTiles(new ArrayList<>(tiles.subList(street.getStart(), street.getEnd())));
        street.modifyTiles();
    }

    /*
    private void setAllImages() {
        for (int i = 0; i < tiles.get(0).size(); i++) {
            setRowImages(i, true);
        }
    }
    */

    /*
    private void setRowImages(int row, boolean start) {
        int i = 0;

        // SI HAY CALLE VALIDA
        if (street.getStart() < tiles.size() && street.getEnd() < tiles.size()) {
            if (start) {
                // Imagenes del comienzo del mapa
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
    }*/

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
                    tile.setY((tile.getY() + tileSize) - height + (int)Math.round(pixelPerSpeed)); // Cuando llegan al limite van al inicio otra vez

                    if (i == tiles.size() - 1) {
                        /*for (int s = 0; s < tiles.size(); s++) {
                            //tile.setImage(Loader.getSprites().get("Pasto/PastoParejo"));
                            tiles.get(s).get(j).setImage(null); // W
                            //tile.setImage(null);
                            //tiles.get(i).get(j).setImage(null);
                        }*/


                        leftSide.modifyFirstRow(j);
                        rightSide.modifyFirstRow(j);
                        street.modifyFirstRow(j);
                    }

                    /*
                    if (i == tiles.size() - 1) // Si es la ultima columna
                        setRowImages(j, false); // Se setean nuevas imagenes aleatorias para toda la fila
                     */
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

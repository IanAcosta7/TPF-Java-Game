package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.content.component.drawable.HitBox;
import ar.edu.utn.mdp.content.component.drawable.Tile;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public enum Structure {

    ARBOL(new BufferedImage[][] {
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_02"), Loader.getSprites().get("Arbol/arbolito_04"), Loader.getSprites().get("Arbol/arbolito_06") },
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_01"), Loader.getSprites().get("Arbol/arbolito_03"), Loader.getSprites().get("Arbol/arbolito_05") },
    });

    private BufferedImage[][] image;

    Structure(BufferedImage[][] image) {
        this.image = image;
    }

    public BufferedImage getImage(int x, int y) {
        return image[x][y];
    }

    public int getSizeX() {
        return image.length;
    }

    public int getSizeY() {
        return image[0].length;
    }

    public void setImage(int x, int y, BufferedImage image) {
        this.image[x][y] = image;
    }
}
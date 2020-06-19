package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;

public enum Structure {

    ARBOL(new BufferedImage[][] {
            new BufferedImage[] { Loader.getSprites().get("Arbol/Arbol_05"), Loader.getSprites().get("Arbol/Arbol_03"), Loader.getSprites().get("Arbol/Arbol_01") },
            new BufferedImage[] { Loader.getSprites().get("Arbol/Arbol_06"), Loader.getSprites().get("Arbol/Arbol_04"), Loader.getSprites().get("Arbol/Arbol_02") },
    });

    private BufferedImage[][] images;

    Structure(BufferedImage[][] images) {
        this.images = images;
    }

    public BufferedImage getImage(int i, int j) {
        return images[i][j];
    }

    public int getSizeX() {
        return images.length;
    }

    public int getSizeY() {
        return images[0].length;
    }
}
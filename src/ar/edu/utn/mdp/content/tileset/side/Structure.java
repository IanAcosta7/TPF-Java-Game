package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;

public enum Structure {

    ARBOL(new BufferedImage[][] {
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_02"), Loader.getSprites().get("Arbol/arbolito_04"), Loader.getSprites().get("Arbol/arbolito_06") },
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_01"), Loader.getSprites().get("Arbol/arbolito_03"), Loader.getSprites().get("Arbol/arbolito_05") },
    }, 0, 0);

    private BufferedImage[][] images;
    private int xPosition;
    private int yPosition;

    Structure(BufferedImage[][] images, int xPosition, int yPosition) {
        this.images = images;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public BufferedImage getImage(int x, int y) {
        return images[x][y];
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getSizeX() {
        return images.length;
    }

    public int getSizeY() {
        return images[0].length;
    }

    /*public void setImage(int x, int y, BufferedImage image) {
        this.images[x][y] = image;
    }*/

    /**
     * @param img: Una imagen
     * @return: Si encuentra una estructura con esa imagen, retorna su nombre. Sino retorna null.
     */
    public static String getName(BufferedImage img) {
        String name = null;

        for (Structure structure : values())
            for (BufferedImage[] imgRow : structure.images)
                for (BufferedImage image : imgRow)
                    if (image.equals(img))
                        name = structure.name();

        return name;
    }
}
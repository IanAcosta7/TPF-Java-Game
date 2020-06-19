package ar.edu.utn.mdp.content.tileset.side;

import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;

public enum Structure {

    ARBOL(new BufferedImage[][] {
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_02"), Loader.getSprites().get("Arbol/arbolito_04"), Loader.getSprites().get("Arbol/arbolito_06") },
            new BufferedImage[] { Loader.getSprites().get("Arbol/arbolito_01"), Loader.getSprites().get("Arbol/arbolito_03"), Loader.getSprites().get("Arbol/arbolito_05") },
    }, 0);

    private BufferedImage[][] images;
    private int count;

    Structure(BufferedImage[][] images, int count) {
        this.images = images;
        this.count = count;
    }

    /**
     * Retorna la imagen ubicada en la pos <tt>pos</tt> en <i>row-major order</i>.
     *
     * @param pos
     * @return
     */
    /*public BufferedImage getImage(int pos) {
        BufferedImage image = null;
        int k = 0;

        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[i].length; i++) {
                if (k == pos)
                    image = images[i][j];

                k++;
            }
        }

        return image;
    }*/

    public BufferedImage getNextImage() {
        int k = 0;

        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[i].length; j++) {
                if (k == count) {
                    count++;
                    return images[i][j];
                }
                k++;
            }
        }

        return null;
    }

    public BufferedImage getImage(int i, int j) {
        return images[i][j];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
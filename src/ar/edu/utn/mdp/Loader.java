package ar.edu.utn.mdp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Loader{
    private HashMap<String, BufferedImage> sprites;

    public Loader() {
        this.sprites = new HashMap<>();
    }

    public void load(String name, String path) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(Loader.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        sprites.put(name, img);
    }

    public HashMap<String, BufferedImage> getSprites() {
        return sprites;
    }

    private BufferedImage loadImage(){ return null; }
}

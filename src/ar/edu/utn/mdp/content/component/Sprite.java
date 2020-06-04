package ar.edu.utn.mdp.content.component;

import ar.edu.utn.mdp.utils.Loader;

import java.awt.image.BufferedImage;

public class Sprite extends Component
{
    private BufferedImage image;

    public Sprite(String name, int x, int y, int rotation, int width, int height, String image)
    {
        super(name, x, y, rotation, width, height);
        this.image = Loader.getSprites().get(image);
    }

    public Sprite(String name, int x, int y, int rotation, int width, int height)
    {
        super(name, x, y, rotation, width, height);
        this.image = null;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage img) {
        this.image = img;
    }
}

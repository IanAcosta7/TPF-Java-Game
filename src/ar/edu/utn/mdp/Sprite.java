package ar.edu.utn.mdp;

import java.awt.image.BufferedImage;

public class Sprite extends Component
{
    private BufferedImage image;

    public Sprite(int x, int y, int rotation, int width, int height, String image)
    {
        super(x, y, rotation, width, height);
        this.image = Loader.getSprites().get(image);
    }

    public BufferedImage getImage()
    {
        return image;
    }
}

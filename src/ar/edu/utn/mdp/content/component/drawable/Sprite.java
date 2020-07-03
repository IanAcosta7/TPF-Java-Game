package ar.edu.utn.mdp.content.component.drawable;

import ar.edu.utn.mdp.content.component.Component;
import ar.edu.utn.mdp.utils.Loader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Component implements Drawable
{
    protected BufferedImage image;
    protected HitBox hitBox;

    public Sprite(String name, int x, int y, int rotation, int width, int height, String image)
    {
        super(name, x, y, rotation, width, height);
        this.image = Loader.getSprites().get(image);
        this.hitBox = null;
    }

    public Sprite(String name, int x, int y, int rotation, int width, int height, String image, HitBox hitBox)
    {
        super(name, x, y, rotation, width, height);
        this.image = Loader.getSprites().get(image);
        this.hitBox = hitBox;
    }

    public Sprite(String name, int x, int y, int rotation, int width, int height)
    {
        super(name, x, y, rotation, width, height);
        this.image = null;
    }
    /**
     *
     * @return Retorna la HitBox
     */
    public HitBox getHitBox() {
        return hitBox;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }

    /**
     *
     * @return Retorna una imagen.
     */
    public BufferedImage getImage()
    {
        return image;
    }

    /**
     * Establece una imagen
     * @param img Se pasa una imagen por parametro.
     */
    public void setImage(BufferedImage img) {
        this.image = img;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
}

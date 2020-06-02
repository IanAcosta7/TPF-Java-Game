package ar.edu.utn.mdp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Loader{
    private static HashMap<String, BufferedImage> sprites;

    public Loader()
    {
        this.sprites = new HashMap<>();
        loadAll();
    }

    public void loadAll()
    {
        ArrayList<String> paths= new ArrayList<>();
        paths.add("autoN1");
        paths.add("autoN2");
        paths.add("autoN3");
        paths.add("autoN4");
        paths.add("autoN5");
        //paths.add("");

        for(String path: paths)
        {
            load(path, "/"+path+".png");
        }

    }

    public void load(String name, String path)
    {
        BufferedImage img = null;
        try
        {
            img=ImageIO.read(Loader.class.getResource(path));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            sprites.put(name,img);
        }
    }

    public static HashMap<String, BufferedImage> getSprites() {
        return sprites;
    }

    private BufferedImage loadImage(){ return null; }
}

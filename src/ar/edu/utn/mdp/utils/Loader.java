package ar.edu.utn.mdp.utils;

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
        paths.add("Autos/autoN1");
        paths.add("Autos/autoN2");
        paths.add("Autos/autoN3");
        paths.add("Autos/autoN4");
        paths.add("Autos/autoN5");

        paths.add("Pasto/PastoAlter");
        paths.add("Pasto/PastoAlter2");
        paths.add("Pasto/PastoFlorAmarilla");
        paths.add("Pasto/PastoFlorRoja");
        paths.add("Pasto/PastoParejo");

        paths.add("Calle/asfaltoConLinea");
        paths.add("Calle/asfaltoLadoDer");
        paths.add("Calle/asfaltoLadoIzq");
        paths.add("Calle/asfaltoLiso");

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

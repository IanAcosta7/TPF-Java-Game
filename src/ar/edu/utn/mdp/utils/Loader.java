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

    /**
     * En este metodo se cargan en un Array las imagenes de autos, pasto y calle.
     */
    public void loadAll()
    {
        ArrayList<String> paths= new ArrayList<>();
        paths.add("Autos/autoN1");
        paths.add("Autos/autoN2");
        paths.add("Autos/autoN3");
        paths.add("Autos/autoN4");
        paths.add("Autos/autoN5");
        paths.add("Autos/camion");


        paths.add("Pasto/PastoAlter");
        paths.add("Pasto/PastoAlter2");
        paths.add("Pasto/PastoFlorAmarilla");
        paths.add("Pasto/PastoFlorRoja");
        paths.add("Pasto/PastoParejo");

        paths.add("Calle/asfaltoConLinea");
        paths.add("Calle/asfaltoLadoDer");
        paths.add("Calle/asfaltoLadoIzq");
        paths.add("Calle/asfaltoLiso");

        paths.add("Arbol/Arbol_01");
        paths.add("Arbol/Arbol_02");
        paths.add("Arbol/Arbol_03");
        paths.add("Arbol/Arbol_04");
        paths.add("Arbol/Arbol_05");
        paths.add("Arbol/Arbol_06");

        for(String path: paths)
        {
            load(path, "/"+path+".png");
        }

    }

    /**
     * Se cargan en un HashMap las imagenes con un nombre.
     * @param name
     * @param path
     */
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

    /**
     *
     * @return Retorna una imagen con el nombre.
     */
    public static HashMap<String, BufferedImage> getSprites() {
        return sprites;
    }

    private BufferedImage loadImage(){ return null; }
}

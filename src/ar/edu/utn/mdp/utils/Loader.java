package ar.edu.utn.mdp.utils;

import ar.edu.utn.mdp.utils.exception.AssetsFileNotFoundException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Loader{
    private static HashMap<String, BufferedImage> sprites;

    /**
     * En este metodo se lee de un Json las imagenes de autos, pasto y calle.
     */
    public static void loadAll() throws AssetsFileNotFoundException {
        File file= new File("assets/assetsPath.json");

        if(!file.exists())
            throw new AssetsFileNotFoundException("El archivo no existe");


        try {
            JSONArray jsonArray = new JSONArray(JSONUtils.load("assets/assetsPath.json"));

            for (int i = 0; i < jsonArray.length(); i++) {
                String path = jsonArray.getString(i);
                load(path, "/"+path+".png");
            }

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    /**
     * Se cargan en un HashMap las imagenes con un nombre.
     * @param name
     * @param path
     */
    private static void load(String name, String path)
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

    static {
        sprites = new HashMap<>();
    }
}

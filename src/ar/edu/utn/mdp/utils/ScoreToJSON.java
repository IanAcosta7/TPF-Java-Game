package ar.edu.utn.mdp.utils;

import ar.edu.utn.mdp.content.persistent.Score;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;


public abstract class ScoreToJSON {

    public static void save(JSONArray jsonArray) {
        String PATH = "data/scores.JSON";
        try {
            FileWriter file = new FileWriter(PATH);
            file.write(jsonArray.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String load(String PATH)
    {
        String content = null;
        try
        {
            content = new String(Files.readAllBytes(Paths.get(PATH)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }

    public static JSONArray toJSON(HashSet score){
        JSONArray jsonArray = new JSONArray();

        Iterator<Score> iterator = score.iterator();

        while (iterator.hasNext()){
            jsonArray.put(iterator.next().toJSON());
        }
        return jsonArray;
    }

}

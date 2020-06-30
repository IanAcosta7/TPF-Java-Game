package ar.edu.utn.mdp.content.persistent;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Score implements Serializable {

    private String name;
    private int score;

    public Score(String name, int score) {
        if (name.length() > 2)
            this.name = name.toUpperCase().substring(0, 3); // Solo tomamos los primeros caracteres del nombre
        else
            this.name = name.toUpperCase();
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", name);
            jsonObject.put("score", score);
        }catch ( JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj instanceof Score) {
            Score o = (Score) obj;

            if (name.equals(o.getName()))
                return true;
        }

        return false;

        //return (obj instanceof Score && ((Score) obj).getName().equals(name)) || obj == this;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}

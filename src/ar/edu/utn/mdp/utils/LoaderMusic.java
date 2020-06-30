package ar.edu.utn.mdp.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sound.sampled.*;

public abstract class LoaderMusic {
    private static HashMap<String, Clip> sounds;

    public LoaderMusic() {

    }

    public static Clip getClip(String name){
       return sounds.get(name);
    }

    public static void loadAllMusic()
    {
        ArrayList<String> MusicPaths= new ArrayList<>();

        MusicPaths.add("pingFighter");
        MusicPaths.add("RUIDO_CHOQUE");

        for(String path: MusicPaths)
        {
            loadMusic(path,"assets/Music/"+path+".wav");
        }
    }

    private static void loadMusic(String path, String MusicPath)
    {
        try {
            File file = new File(MusicPath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);

            try{
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                sounds.put(path,clip);
            }catch (LineUnavailableException e){
                e.printStackTrace();
            }


        } catch (UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        }
    }
    static{
        sounds=new HashMap<>();
    }
}
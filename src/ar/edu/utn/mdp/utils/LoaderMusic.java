package ar.edu.utn.mdp.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sound.sampled.*;

public abstract class LoaderMusic {
    private Mixer mixer;
    private TargetDataLine line;
    private AudioFileFormat aff;
    private static HashMap<String, Clip> sounds;

    public LoaderMusic() {

    }

    public static Clip getName(String name){
       return sounds.get(name);
    }

    public static void loadAllMusic()
    {
        ArrayList<String> MusicPaths= new ArrayList<>();
        MusicPaths.add("pingFighter");

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
/*
            int bytesPerFrame = audio.getFormat().getFrameSize();
            if (bytesPerFrame == AudioSystem.NOT_SPECIFIED) {
                bytesPerFrame = 1;
            }

            int numBytes= 1024 * bytesPerFrame;
            byte[] audioBytes = new byte[numBytes];

            try{
                int numBytesRead = 0;
                int numFramesRead = 0;


                while((numBytesRead=audio.read(audioBytes))!=-1){
                    numFramesRead=numBytesRead/bytesPerFrame;
                    totalFramesRead += numFramesRead;

                }
            }catch (Exception e){
                e.printStackTrace();
            }
*/
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
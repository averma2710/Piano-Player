package model;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

import static ui.Main.keysPlayer;

public class Recorder {


    ArrayList<String> music = new ArrayList<>();
    Piano piano = new Piano();


    public Recorder(ArrayList<String> keys) {
        music = keys;
    }

    public void addRecorder(String key) {
        music.add(key);
    }


    public ArrayList getMusic() {
        return music;
    }

    public String recordedMusic(int i) {
        return music.get(i);
    }
}


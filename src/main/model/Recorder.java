package model;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

import static ui.Main.keysPlayer;

public class Recorder {


    ArrayList<String> music = new ArrayList<>();
    Piano piano = new Piano();

    //EFFECTS: sets music to keys.
    //MODIFIES: this

    public Recorder(ArrayList<String> keys) {
        music = keys;
    }
    //EFFECTS: Adds key to music.
    //MODIFIES: this

    public void addRecorder(String key) {
        music.add(key);
    }

    //EFFECTS: Returns music.

    public ArrayList getMusic() {
        return music;
    }
    //EFFECTS: Returns string at index i from list music.

    public String recordedMusic(int i) {
        return music.get(i);
    }
}


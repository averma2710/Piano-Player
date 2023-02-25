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

    public void recordedPlayer() throws LineUnavailableException,
            IOException, UnsupportedAudioFileException, InterruptedException {
        Thread.sleep(2000);
        System.out.println(music.size());
        for (int i = 0; i < music.size(); i++) {
            System.out.println(music.get(i));
            keysPlayer(music.get(i));
            Thread.sleep(1000);
        }
    }
}


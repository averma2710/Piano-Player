package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Piano {
    File file;

    public Piano() {

    }

    public void music(String keys) throws LineUnavailableException, IOException, UnsupportedAudioFileException {


        if (keys.equals("a")) {
            file = new File("src/main/key01.wav");
        }  else if (keys.equals("s"))  {
            file = new File("src/main/key02.wav");
        }  else if (keys.equals("d"))  {
            file = new File("src/main/key03.wav");
        }  else if (keys.equals("f")) {
            file = new File("src/main/key04.wav");
        }  else if (keys.equals("g"))  {
            file = new File("src/main/key05.wav");
        }  else if (keys.equals("h")) {
            file = new File("src/main/key06.wav");
        }  else if (keys.equals("j")) {
            file = new File("src/main/key07.wav");
        }  else if (keys.equals("k")) {
            file = new File("src/main/key08.wav");
        }  else if (keys.equals("l")) {
            file = new File("src/main/key09.wav");
        }

        AudioInputStream a = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(a);
        clip.start();

    }



}

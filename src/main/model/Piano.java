package model;

import org.json.JSONObject;
import persisitence.Writable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

//Assigns a sound fie to particular key entered by user.

public class Piano implements Writable {
    File file;
    String keys;
//Constructs a Piano.

    public Piano() {

    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    //EFFECTS returns music file.
    public File music(String keys) throws LineUnavailableException, IOException, UnsupportedAudioFileException {


        if (keys.equals("a")) {
            return file = new File("src/main/key01.wav");
        } else if (keys.equals("s")) {
            return file = new File("src/main/key02.wav");
        } else if (keys.equals("d")) {
            return file = new File("src/main/key03.wav");
        } else if (keys.equals("f")) {
            return file = new File("src/main/key04.wav");
        } else if (keys.equals("g")) {
            return file = new File("src/main/key05.wav");
        } else if (keys.equals("h")) {
            return file = new File("src/main/key06.wav");
        } else if (keys.equals("j")) {
            return file = new File("src/main/key07.wav");
        } else if (keys.equals("k")) {
            return file = new File("src/main/key08.wav");
        } else if (keys.equals("l")) {
            return file = new File("src/main/key09.wav");
        } else {
            return file = new File("src/main/key09.wav");
        }


    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("key", keys);
        return json;
    }
}



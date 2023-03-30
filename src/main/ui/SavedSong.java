package ui;

import model.Progress;
import model.Recorder;

import javax.swing.*;
import java.util.ArrayList;

// new JFrame for the recordings

public class SavedSong extends JFrame {
    JLabel recordings;
    Progress progress;
    Recorder record;
    ArrayList<String> music;

 // EFFECTS : constructor for the saved songs JFrame
    SavedSong(Progress p) {
        this.progress = p;
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Recordings");
        this.setLayout(null);

    }

    // EFFECTS : creates  label for the new JFrame
    // MODIFIES : this

    public void labelMaker() {
        for (int i = 0; i < progress.getRecordings().size(); i++) {
            recordings = new JLabel();
            ArrayList<String> music = new ArrayList<>();
            record = progress.getRecorder(i);
            music = record.getMusic();
            String mus = music.toString();
            recordings.setText("record " + String.valueOf(i + 1) + " " + mus);
            recordings.setBounds(50, i * 30, 300,30);
            this.add(recordings);
        }
    }
}


package ui;

import model.Piano;
import model.Progress;
import model.Recorder;
import org.json.JSONWriter;
import persisitence.JsonReader;
import persisitence.WriterJson;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static ui.Helper.*;

// Represents a JFrame for virtual piano.

public class MyFrame extends JFrame implements ActionListener, KeyListener {
    JButton random;
    JButton save;
    SavedSong songs;
    JButton play;
    JButton remove;
    JButton reorder;
    JButton recordings;
    JLabel currKey;
    JLabel whichRecord;
    String key;
    Boolean remover = false;
    Boolean isRecording = false;
    Boolean recordingNumber = false;
    Boolean randomPlayer = false;
    ArrayList<String> recs = new ArrayList<>();
    Progress progress = new Progress();
    ArrayList<String> list = new ArrayList<>();
    Recorder recorder = new Recorder(list);
    Helper helper;
    WriterJson writerJson;
    JsonReader jsonReader;
    final String speaker = "./data/speaker.json";

    // EFFECTS: constructor for the j frame.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    MyFrame() {
        helper = new Helper();
        writerJson = new WriterJson(speaker);
        jsonReader = new JsonReader(speaker);
        buttonMaker();
        currKey = new JLabel();
        currKey.setText(key);
        currKey.setBounds(250, 40, 500, 30);
        Font font = currKey.getFont();
        float size = font.getSize() + 10;
        currKey.setFont(font.deriveFont(size));
        whichRecord = new JLabel();
        whichRecord.setText("");
        whichRecord.setBounds(350, 330, 500, 30);
        Font fontSize = whichRecord.getFont();
        float sizeFont = fontSize.getSize() + 3;
        whichRecord.setFont(font.deriveFont(sizeFont));
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Virtual Piano");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.addKeyListener(this);
        try {
            JLabel bgImg = new JLabel(new ImageIcon(ImageIO.read(new File("src/piano.png"))));
            this.setContentPane(bgImg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(play);
        this.add(random);
        this.add(currKey);
        this.add(recordings);
        this.add(whichRecord);
        this.add(remove);
        this.add(reorder);
        this.add(save);
        pack();
        int result = JOptionPane.showConfirmDialog(this,"Do you wish to load?", "Load",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            try {
                progress = jsonReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    //EFFECTS : maker for the buttons.
    //MODIFIES : this

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void buttonMaker() {
        save = new JButton();
        save.setBounds(850, 230, 100, 100);
        save.setText("Save");
        save.addActionListener(this);
        remove = new JButton();
        remove.setBounds(740, 10, 100, 100);
        remove.setText("remove record");
        remove.addActionListener(this);
        reorder = new JButton();
        reorder.setBounds(850, 10, 100, 100);
        reorder.setText("re-order");
        reorder.addActionListener(this);
        play = new JButton();
        play.setBounds(10, 120, 100, 100);
        play.setText("Random player");
        play.addActionListener(this);
        recordings = new JButton();
        recordings.setBounds(10, 230, 100, 100);
        recordings.setText("Recordings");
        recordings.addActionListener(this);
        random = new JButton();
        random.setBounds(10, 10, 100, 100);
        random.setText("Record");
        random.addActionListener(this);
        play.setFocusable(false);
        random.setFocusable(false);
        recordings.setFocusable(false);
        save.setFocusable(false);
        remove.setFocusable(false);
        reorder.setFocusable(false);
    }

    // EFFECTS : tracks the action performed.
    // MODIFIES : this
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == random) {
            currKey.setText("Recording now");
            whichRecord.setText("");
            isRecording = true;
            remover = false;
            recordingNumber = false;
            randomPlayer = false;
        }
        if (e.getSource() == play) {
            currKey.setText("Play any random keys");
            randomPlayer = true;
            isRecording = false;
            remover = false;
            recordingNumber = false;
        }

        if (e.getSource() == recordings) {
            currKey.setText("You have " + String.valueOf(progress.getRecordings().size()) + "Recordings");
            whichRecord.setText("enter the number of recording you want to play");
            songs = new SavedSong(progress);
            songs.labelMaker();
            recordingNumber = true;
            isRecording = false;
            remover = false;
            randomPlayer = false;

        }
        if (e.getSource() == remove) {
            recordingNumber = false;
            whichRecord.setText("Enter the record number to remove ");
            currKey.setText("");
            remover = true;
            recordingNumber = false;
            isRecording = false;
            randomPlayer = false;
        }
        if (e.getSource() == reorder) {
            currKey.setText("Shuffled your music!!");
            Collections.shuffle(progress.getRecordings());
            recordingNumber = false;
            isRecording = false;
            remover = false;
            randomPlayer = false;
        }
        if (e.getSource() == save) {
            currKey.setText("Saved");
            recordingNumber = false;
            isRecording = false;
            remover = false;
            randomPlayer = false;
            try {
                writerJson.open();
                writerJson.write(progress);
                writerJson.close();
                System.out.println("Saved music to " + speaker);
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to write to file: " + speaker);
            }
        }
    }

    // EFFECTS  : Tracks the key typed
    // MODIFIES : this

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void keyTyped(KeyEvent e) {
        String k = String.valueOf(e.getKeyChar());
        int i = Character.getNumericValue(e.getKeyChar());
        if (recordingNumber) {
            randomPlayer = false;
            whichRecord.setText("");
            Recorder tempRecorder = progress.getRecorder(i - 1);
            ArrayList<String> tempMusic = tempRecorder.getMusic();
            currKey.setText("just testing");
            currKey.revalidate();
            for (int j = 0; j < tempRecorder.getMusic().size(); j++) {
                currKey.setText(tempMusic.get(j));
                try {
                    keysPlayer(tempRecorder.recordedMusic(j));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            currKey.setText("");
            recordingNumber = false;
        }
        if (isRecording) {
            randomPlayer = false;
            recorder.addRecorder(k);
            currKey.setText(k);
            if (recorder.getMusic().size() > 10) {
                progress.addRecording(recorder);
                ArrayList<String> emptyList = new ArrayList<>();
                recorder = new Recorder(emptyList);
                currKey.setText("record has been added!!!");
                isRecording = false;
            }
        }
        if (randomPlayer) {
            key = k;
            currKey.setText(key);
            try {
                randomPlayer(k);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (remover) {
            progress.getRecordings().remove(i - 1);
            currKey.setText("Removed " + "Record " + ":" + String.valueOf(i));
            remover = false;
        }
    }

    //EFFECTS : tracks the key pressed


    @Override
    public void keyPressed(KeyEvent e) {


    }

   //EFFECTS : tracks the key released

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
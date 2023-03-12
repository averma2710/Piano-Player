package ui;

import model.*;
import persisitence.*;
import persisitence.JsonReader;

import javax.sound.sampled.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
//Represents the piano where music is played.

public class Main extends Helper {
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws LineUnavailableException, IOException,
            UnsupportedAudioFileException, InterruptedException {




        Piano piano = new Piano();
        Learn learn = new Learn();
        Helper h = new Helper();
        PlayLearn learner = new PlayLearn(0, "");
        Progress progress = new Progress();
        int num;
        final String SPEAKER = "./data/speaker.json";
        WriterJson wj = new WriterJson(SPEAKER);
        JsonReader jr = new JsonReader(SPEAKER);
        Scanner key = new Scanner(System.in);


        System.out.println("Do you wish to load the data? (y/n)");
        String helper = key.nextLine();

        if (helper.equals("y")) {
            progress = jr.read();
        }



        while (true) {
            menu();
            String keys1 = key.nextLine();
            if (keys1.equals("L")) {
                starter();
                keys1 = key.nextLine();
                if (keys1.equals("M")) {
                    System.out.println(learn.moos());
                } else if (keys1.equals("F")) {
                    System.out.println(learn.fur());
                } else if (keys1.equals("PLAY")) {
                    gameStarter();
                    String pattern = key.nextLine();
                    h.gameInitializer(learner.checks(pattern));
                    for (int i = 0; i < learner.getPattern().length(); i++) {
                        String inputs = key.nextLine();
                        System.out.println(learner.niceOrWrong(inputs, i));
                    }
                    h.gameEnd(learner.getScore());
                    learner.setScore(0);
                }

            } else if (keys1.equals("R")) {
                ArrayList<String> tempRecord = new ArrayList<>();
                recordingMenu();
                for (int i = 0; i < 10; i++) {
                    keys1 = key.nextLine();
                    tempRecord.add(keys1);
                }
                progress.addRecording(new Recorder(tempRecord));


            } else if (keys1.equals("QS")) {
                if (helper.equals("y")) {
                    try {
                        wj.open();
                        wj.write(progress);
                        wj.close();
                        System.out.println("Saved music to " + SPEAKER);
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to write to file: " + SPEAKER);
                    }
                    break;
                }
                try {
                    Progress tempSave = jr.read();
                    ArrayList<Recorder> tempR = progress.getRecordings();
                    for (Recorder r : tempR) {
                        tempSave.addRecording(r);
                    }
                    wj.open();
                    wj.write(tempSave);
                    wj.close();
                    System.out.println("Saved music to " + SPEAKER);
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to write to file: " + SPEAKER);
                }
                break;

            } else if (keys1.equals("Q")) {
                break;
            } else if (keys1.equals("RECORDS")) {
                System.out.println("You have recorded " + progress.getRecordings().size() + " notes so far");
                System.out.println("Enter the number of the recording you want to play");
                num = key.nextInt();
                if (num > progress.getRecordings().size()) {
                    System.out.println("You don't have enough number of recording to play");
                } else {
                    Recorder tempRecorder = progress.getRecorder(num - 1);
                    for (int i = 0; i < tempRecorder.getMusic().size(); i++) {
                        System.out.println(tempRecorder.recordedMusic(i));
                        keysPlayer(tempRecorder.recordedMusic(i));
                        Thread.sleep(1000);
                    }
                }


            } else if (keys1.equals("RANDOM")) {
                randomPlayerStarter();
                while (true) {
                    keys1 = key.nextLine();
                    if (keys1.equals("QUIT")) {
                        break;
                    } else {
                        keysPlayer(keys1.substring(0, 1));
                    }

                }
            } else {
                System.out.println("Enter correct key");
            }
        }
    }
    //EFFECTS: Plays the sound associated with the string key.
    //MODIFIES: this

    public static void keysPlayer(String key) throws LineUnavailableException,
            IOException, UnsupportedAudioFileException {

        Piano piano = new Piano();
        AudioInputStream a = AudioSystem.getAudioInputStream(piano.music(key));
        Clip clip = AudioSystem.getClip();
        clip.open(a);
        clip.start();
    }

}



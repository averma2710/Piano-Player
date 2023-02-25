package ui;

import model.*;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
public class Main {
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws LineUnavailableException, IOException,
            UnsupportedAudioFileException, InterruptedException {




        Piano piano = new Piano();
        Learn learn = new Learn();
        PlayLearn learner = new PlayLearn(0, "");
        Progress progress = new Progress();
        int num;



        while (true) {
            System.out.println("#############################################");
            System.out.println("\n \t \t WELCOME TO MY VIRTUAL PIANO\n\n");
            System.out.println("\t - Play piano or Learn piano\n");
            System.out.println("\t - Press L to learn\n");
            System.out.println("\t - To record your sound enter R\n");
            System.out.println("\t - To enter random keys player enter RANDOM \n");
            System.out.println("\t - To play your recording enter RECORDS \n");
            System.out.println("\t - To quit, enter Q");
            Scanner key = new Scanner(System.in);
            String keys1 = key.nextLine();
            if (keys1.equals("L")) {
                System.out.println("To play the game enter PLAY \n");
                System.out.println("To learn enter M for Moose or F for Furlise \n");
                keys1 = key.nextLine();
                if (keys1.equals("M")) {
                    System.out.println(learn.moos());
                } else if (keys1.equals("F")) {
                    System.out.println(learn.fur());
                } else if (keys1.equals("PLAY")) {
                    System.out.println("Select a pattern you want to play with \n");
                    System.out.println("Enter MOOSE, FUR, AVR, or any key for default pattern");
                    String patt = key.nextLine();
                    learner.checks(patt); // pattern setter
                    System.out.println("\n" + learner.getPattern() + "\n");
                    System.out.println("START");
                    for (int i = 0; i < learner.getPattern().length(); i++) {
                        String inputs = key.nextLine();
                        System.out.println(learner.niceOrWrong(inputs, i));
                    }
                    System.out.println("\n Your score is " + learner.getScore());
                    System.out.println(learner.scorer());
                }

            } else if (keys1.equals("R")) {
                ArrayList<String> tempRecord = new ArrayList<>();
                System.out.println("Your beats will now be recorded");
                System.out.println("recording length must be of 10 keys");
                for (int i = 0; i < 10; i++) {
                    keys1 = key.nextLine();
                    tempRecord.add(keys1);
                }
                progress.addRecording(new Recorder(tempRecord));
                System.out.println(progress.getRecordings().size());

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
                System.out.println("enter keys to play music \n");
                System.out.println("to quit enter QUIT");
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

    public static void keysPlayer(String key) throws LineUnavailableException,
            IOException, UnsupportedAudioFileException {

        Piano piano = new Piano();
        AudioInputStream a = AudioSystem.getAudioInputStream(piano.music(key));
        Clip clip = AudioSystem.getClip();
        clip.open(a);
        clip.start();
    }
}



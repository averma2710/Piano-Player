package ui;

import model.Learn;
import model.Piano;
import model.PlayAndLearn;
import model.Recorder;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        Piano piano = new Piano();
        Learn learn = new Learn();


        Scanner key = new Scanner(System.in);
        while (true) {
            System.out.println("Play piano or Learn piano");
            System.out.println("Press L to learn and keys if you want to play");
            System.out.println("To record your sound enter R");
            String keys = key.nextLine();
            if (keys.equals("L")) {
                System.out.println("PLAY the game to check you progress to play enter PLAY");
                System.out.println("Moose or Furlise");
                keys = key.nextLine();
                if (keys.equals("M")) {
                    System.out.println(learn.moos());
                } else if (keys.equals("F")) {
                    System.out.println(learn.fur());
                } else if (keys.equals("PLAY")) {
                    System.out.println("Select a pattern you want to play with");
                    PlayAndLearn play = new PlayAndLearn();
                    play.letsplay();
                } else if (keys.equals("G")) {
                    System.out.println("Your beats will now be recorded");
                    keys = key.nextLine();
                    Recorder record = new Recorder();
                    record.recordmusic(keys);
                } else {
                    System.out.println("press appropiate key");
                }
            } else {
                piano.music(keys);


            }
        }
    }
}

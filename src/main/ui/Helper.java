package ui;

import model.PlayLearn;
import model.Progress;
import persisitence.WriterJson;

import java.io.FileNotFoundException;

// Represents a helper that cleans the main ui

public class Helper {

// constructs a helper
    public Helper() {
    }
//EFFECTS: prints a menu to clean menu.

    public static void menu() {
        System.out.println("#############################################");
        System.out.println("\n \t \t WELCOME TO MY VIRTUAL PIANO\n\n");
        System.out.println("\t - Play piano or Learn piano\n");
        System.out.println("\t - Press L to learn\n");
        System.out.println("\t - To record your sound enter R\n");
        System.out.println("\t - For free play enter RANDOM \n");
        System.out.println("\t - To play your recording enter RECORDS \n");
        System.out.println("\t - To quit and save your recording press QS");
        System.out.println("\t - To quit, enter Q");
    }
    //EFFECTS: prints player starter menu.

    public static void starter() {
        System.out.println("To play the game enter PLAY \n");
        System.out.println("To learn enter M for Moose or F for Furlise \n");
    }
    //EFFECTS: prints game starter menu

    public static void gameStarter() {
        System.out.println("Select a pattern you want to play with \n");
        System.out.println("Enter MOOSE, FUR, AVR, or any key for default pattern");
    }
    //EFFECTS: performs the function to end the game

    public void gameEnd(int i) {
        PlayLearn learner = new PlayLearn(i, "");
        System.out.println("\n Your score is " + i);
        System.out.println(learner.scorer());
    }
    //EFFECTS: initializes a game.

    public void gameInitializer(String s) {
        PlayLearn learner = new PlayLearn(0, s);
        System.out.println("\n" + learner.getPattern() + "\n");
        System.out.println("START");

    }
    //EFFECTS: prints the recording menu

    public static void recordingMenu() {
        System.out.println("Your beats will now be recorded");
        System.out.println("recording length must be of 10 keys");
    }
    //EFFECTS: prints out random player starter menu.

    public static void randomPlayerStarter() {
        System.out.println("enter keys to play music \n");
        System.out.println("press keys a s d f g h j k l for different sounds, " + "any key for default sound \n");
        System.out.println("except the enter key");
        System.out.println("to quit enter QUIT");
    }

}


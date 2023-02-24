package model;

import java.util.Scanner;

public class PlayAndLearn {
    Learn learn = new Learn();
    String pattern;
    int score = 0;
    int length;

    public PlayAndLearn() {
    }

    public void letsplay() {
        Scanner answer = new Scanner(System.in);
        String caps = answer.nextLine();
        if (caps.equals("MOOSE")) {
            pattern = learn.moos();

        } else if (caps.equals("FUR")) {
            pattern = learn.fur();
        }

        System.out.println(pattern);
        System.out.println("START");
        length = pattern.length();
        for (int i = 0; i < length; i++) {
            caps = answer.nextLine();
            if (caps.equals(pattern.substring(i, i + 1))) {
                System.out.println("NICE");
                score++;
            } else {
                System.out.println("wrong");
            }
        }
        System.out.println("Your Score is " + score);
        if (score > 5) {
            System.out.println("Nice score ");
        } else {
            System.out.println("YOU NEED MORE PRACTICE press G to play again");
            caps = answer.nextLine();
            if (caps.equals("G")) {
                PlayAndLearn play = new PlayAndLearn();
                play.letsplay();
            }
        }
    }
}
